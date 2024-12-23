package com.empresa.gestor_vendas.venda.application.service;

import com.empresa.gestor_vendas.cliente.application.repository.ClienteRepository;
import com.empresa.gestor_vendas.cliente.domain.Cliente;
import com.empresa.gestor_vendas.handler.APIException;
import com.empresa.gestor_vendas.produto.application.repository.ProdutoRepository;
import com.empresa.gestor_vendas.produto.domain.Produto;
import com.empresa.gestor_vendas.venda.application.api.dto.EstoqueItemResponse;
import com.empresa.gestor_vendas.venda.application.api.dto.VendaRequest;
import com.empresa.gestor_vendas.venda.application.api.dto.VendaResponse;
import com.empresa.gestor_vendas.venda.application.api.dto.VerificaLimiteResponse;
import com.empresa.gestor_vendas.venda.application.repository.VendaRepository;
import com.empresa.gestor_vendas.venda.domain.ItemVenda;
import com.empresa.gestor_vendas.venda.domain.StatusVenda;
import com.empresa.gestor_vendas.venda.domain.Venda;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.empresa.gestor_vendas.venda.domain.Venda.criaVenda;

@Service
@Log4j2
@RequiredArgsConstructor
public class VendaApplicationService implements VendaService {
    private final VendaRepository vendaRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;

    @Override
    public VendaResponse abreVenda(VendaRequest vendaRequest) {
        log.info("[start] VendaApplicationService - abreVenda");
        Cliente cliente = verificaCliente(vendaRequest.getIdCliente());
        verificaVendasAbertas(vendaRequest.getIdCliente());
        BigDecimal totalComprasAposFechamento = verificaComprasAposFechamento(cliente);
        VerificaLimiteResponse limiteResponse = verificaLimite(vendaRequest.getItens(), cliente, produtoRepository, totalComprasAposFechamento);
        trataLimiteResponse(limiteResponse);
        BigDecimal totalCompra = calculaTotalCompra(vendaRequest.getItens(), produtoRepository);
        Venda vendaCriada = criaVenda(vendaRequest, totalCompra);
        verificaEstoqueItens(vendaRequest);
        vendaRepository.salva(vendaCriada);
        log.info("[finish] VendaApplicationService - abreVenda");
        return new VendaResponse(vendaCriada);
    }

    //< - Verificações - >

    private void verificaVendasAbertas(@NotNull UUID idCliente) {
        List<Venda> vendas = vendaRepository.buscaVendasCliente(idCliente);
        boolean existeVendaAberta = vendas.stream()
                .anyMatch(venda -> StatusVenda.ABERTA.equals(venda.getStatusVenda()));
        if (existeVendaAberta) {
            throw APIException.build(HttpStatus.NOT_FOUND, "O cliente possui uma venda em aberto.");
        } else {
            log.info("O cliente não possui nenhuma  venda em aberto.");
        }

    }

    private void trataLimiteResponse(VerificaLimiteResponse limiteResponse) {
        log.info("[start] VendaApplicationService - trataLimiteResponse");
        if (limiteResponse.isLimiteExcedido()) {
            throw APIException.build(HttpStatus.NOT_FOUND, limiteResponse.getMensagem());
        }
        log.info("[finish] VendaApplicationService - trataLimiteResponse");
    }

    public void verificaEstoqueItens(VendaRequest vendaRequest) {
        log.info("[start] VendaApplicationService - verificaEstoqueItens");

        boolean quantidadeInvalidaItem = vendaRequest.getItens().stream()
                .anyMatch(item -> item.getQuantidade() <= 0);
        if (quantidadeInvalidaItem) {
            throw APIException.build(HttpStatus.BAD_REQUEST, "Todos os itens devem ter uma quantidade mínima de 1.");
        }

        List<EstoqueItemResponse> itensResposta = new ArrayList<>();
        vendaRequest.getItens().forEach(itemVendaRequest -> {
            Produto produtoEstoque = produtoRepository.buscaProduto(itemVendaRequest.getIdProduto());
            boolean temEstoqueSuficiente = produtoEstoque.getEstoque() >= itemVendaRequest.getQuantidade();
            if (temEstoqueSuficiente) {
                produtoEstoque.alteraEstoque(itemVendaRequest.getQuantidade());
            }

            String mensagem = temEstoqueSuficiente
                    ? String.format("Produto com ID %d possui estoque suficiente (%d disponíveis, solicitado: %d).",
                    produtoEstoque.getIdProduto(), produtoEstoque.getEstoque(), itemVendaRequest.getQuantidade())
                    : String.format("Produto com ID %d não possui estoque suficiente (%d disponíveis, solicitado: %d).",
                    produtoEstoque.getIdProduto(), produtoEstoque.getEstoque(), itemVendaRequest.getQuantidade());
            log.info(mensagem);

            itensResposta.add(new EstoqueItemResponse(
                    produtoEstoque.getIdProduto(),
                    produtoEstoque.getEstoque(),
                    itemVendaRequest.getQuantidade(),
                    temEstoqueSuficiente,
                    mensagem
            ));
        });

        boolean todosItensDisponiveis = itensResposta.stream().allMatch(EstoqueItemResponse::isTemEstoqueSuficiente);
        String mensagemFinal = todosItensDisponiveis
                ? "Todos os itens possuem estoque suficiente."
                : "Um ou mais itens não possuem estoque suficiente.";
        log.info("[finish] VendaApplicationService - verificaEstoqueItens");
    }

    public Cliente verificaCliente(UUID idCliente) {
        return clienteRepository.buscaCliente(idCliente);
    }

    public VerificaLimiteResponse verificaLimite(
            List<ItemVenda> itensVenda,
            Cliente cliente,
            ProdutoRepository produtoRepository,
            BigDecimal totalComprasAposFechamento
    ) {
        log.info("[start] VendaApplicationService - verificaLimite");
        BigDecimal total = calculaTotalCompra(itensVenda, produtoRepository);
        BigDecimal saldoDisponivel = cliente.getLimiteCompra().subtract(totalComprasAposFechamento);
        LocalDate proximoFechamento = calculaProximoFechamento(cliente.getDiaFechamento());

        if (total.add(totalComprasAposFechamento).compareTo(cliente.getLimiteCompra()) > 0) {
            String mensagem = String.format(
                    "O valor total dos produtos (%.2f) ultrapassou o limite de compra do cliente (%.2f). " +
                            "O total das compras após o fechamento é (%.2f). O saldo disponível para compra é (%.2f). " +
                            "O próximo fechamento será no dia %s.",
                    total, cliente.getLimiteCompra(), totalComprasAposFechamento, saldoDisponivel,
                    proximoFechamento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
            );

            log.info("[finish] VendaApplicationService - verificaLimite");
            return new VerificaLimiteResponse(
                    true,
                    total,
                    totalComprasAposFechamento,
                    saldoDisponivel,
                    proximoFechamento,
                    mensagem
            );
        }

        return new VerificaLimiteResponse(
                false,
                total,
                totalComprasAposFechamento,
                saldoDisponivel,
                proximoFechamento,
                "O valor total dos produtos está dentro do limite de compra do cliente."
        );
    }

    public BigDecimal verificaComprasAposFechamento(Cliente cliente) {
        log.info("[start] VendaApplicationService - verificaComprasAposFechamento");
        int diaFechamento = cliente.getDiaFechamento();
        List<Venda> vendas = vendaRepository.buscaVendasCliente(cliente.getIdCliente());
        LocalDate hoje = LocalDate.now();
        BigDecimal totalCompras = BigDecimal.ZERO;
        for (Venda venda : vendas) {
            LocalDate diaAbertura = venda.getDiaAbertura().toLocalDate();

            if ((diaAbertura.getDayOfMonth() > diaFechamento ||
                    (diaAbertura.getMonthValue() > hoje.getMonthValue() && diaAbertura.getYear() >= hoje.getYear()))
                    && venda.getStatusVenda() == StatusVenda.FECHADA) {
                totalCompras = totalCompras.add(venda.getValorTotal());
                log.info("Venda realizada após o fechamento e com status FECHADA: " + venda);
            }
        }
        log.info("[finish] VendaApplicationService - verificaComprasAposFechamento");
        return totalCompras;
    }

    public BigDecimal calculaTotalCompra(List<ItemVenda> itensVenda, ProdutoRepository produtoRepository) {
        return itensVenda.stream()
                .map(item -> produtoRepository.buscaProduto(item.getIdProduto()).getPreco().multiply(BigDecimal.valueOf(item.getQuantidade())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public LocalDate calculaProximoFechamento(Integer diaFechamento) {
        log.info("[start] VendaApplicationService - calculaProximoFechamento");
        LocalDate hoje = LocalDate.now();
        LocalDate proximoFechamento;
        if (hoje.getDayOfMonth() > diaFechamento) {
            proximoFechamento = hoje.plusMonths(1).withDayOfMonth(
                    Math.min(diaFechamento, hoje.plusMonths(1).lengthOfMonth()));
        } else {
            proximoFechamento = hoje.withDayOfMonth(Math.min(diaFechamento, hoje.lengthOfMonth()));
        }
        log.info("[finish] VendaApplicationService - calculaProximoFechamento");
        return proximoFechamento;
    }
}

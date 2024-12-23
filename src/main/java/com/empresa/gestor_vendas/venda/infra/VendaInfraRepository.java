package com.empresa.gestor_vendas.venda.infra;

import com.empresa.gestor_vendas.handler.APIException;
import com.empresa.gestor_vendas.venda.application.repository.VendaRepository;
import com.empresa.gestor_vendas.venda.domain.ItemVenda;
import com.empresa.gestor_vendas.venda.domain.Venda;
import com.empresa.gestor_vendas.venda.specification.VendaSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class VendaInfraRepository implements VendaRepository {
    private final VendaSpringDataJPARepository vendaSpringDataJPARepository;

    @Override
    public void salva(Venda vendaCriada) {
        log.info("[start] VendaInfraRepository - salva");
        vendaSpringDataJPARepository.save(vendaCriada);
        log.info("[finish] VendaInfraRepository - salva");
    }

    @Override
    public List<Venda> buscaVendasCliente(UUID idCliente) {
        log.info("[start] VendaInfraRepository - buscaVendasCliente");
        List<Venda> vendas = vendaSpringDataJPARepository.buscaVendasCliente(idCliente);
        log.info("[finish] VendaInfraRepository - buscaVendasCliente");
        return vendas;
    }

    @Override
    public Venda buscaVenda(UUID idVenda) {
        log.info("[start] VendaInfraRepository - buscaVenda");
        Venda venda = vendaSpringDataJPARepository.findById(idVenda)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Venda não encontrada!"));
        log.info("[finish] VendaInfraRepository - buscaVenda");
        return venda;
    }

    @Override
    public List<ItemVenda> buscaItensVenda(UUID idVenda) {
        log.info("[start] VendaInfraRepository - buscaItensVenda");
        List<ItemVenda> itens = vendaSpringDataJPARepository.findByIdVenda(idVenda);
        log.info("[finish] VendaInfraRepository - buscaItensVenda");
        return itens;
    }

    public List<Venda> filtraVendas(UUID idCliente, Integer idProduto, LocalDate inicio, LocalDate fim) {
        log.info("[start] VendaInfraRepository - filtraVendas");
        Specification<Venda> spec = VendaSpecification.filtraVendas(idCliente, idProduto, inicio, fim);
        List<Venda> vendas = vendaSpringDataJPARepository.findAll(spec);
        log.info("[finish] VendaInfraRepository - filtraVendas");
        return vendas;
    }
}

package com.empresa.gestor_vendas.venda.application.repository;

import com.empresa.gestor_vendas.venda.domain.ItemVenda;
import com.empresa.gestor_vendas.venda.domain.Venda;
import org.springframework.data.jpa.repository.EntityGraph;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface VendaRepository {
    @EntityGraph(attributePaths = {"idCliente", "valorTotal"})
    List<Venda> buscaVendasCliente(UUID idCliente);
    void salva(Venda vendaCriada);
    Venda buscaVenda(UUID idVenda);
    List<ItemVenda> buscaItensVenda(UUID idVenda);
    List<Venda> filtraVendas(UUID idCliente, Integer idProduto, LocalDate inicio, LocalDate fim);
    void deletaVenda(UUID idVenda);
}

package com.empresa.gestor_vendas.venda.application.repository;

import com.empresa.gestor_vendas.venda.domain.Venda;

import java.util.List;
import java.util.UUID;

public interface VendaRepository {
    List<Venda> buscaVendasCliente(UUID idCliente);
    void salva(Venda vendaCriada);
    Venda buscaVenda(UUID idVenda);
}

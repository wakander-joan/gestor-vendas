package com.empresa.gestor_vendas.venda.application.service;

import com.empresa.gestor_vendas.venda.application.api.VendaDetalhadaResponse;
import com.empresa.gestor_vendas.venda.application.api.dto.ItemVendaRequets;
import com.empresa.gestor_vendas.venda.application.api.dto.RemoveItemRequets;
import com.empresa.gestor_vendas.venda.application.api.dto.VendaRequest;
import com.empresa.gestor_vendas.venda.application.api.dto.VendaResponse;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface VendaService {
    VendaResponse abreVenda(VendaRequest vendaRequest);
    void fechaVenda(UUID idVenda);
    void addItemVenda(ItemVendaRequets itemVendaRequets, UUID idVenda);
    void removeItemVenda(RemoveItemRequets removeItemRequets, UUID idVenda);
    VendaDetalhadaResponse buscaVenda(UUID idVenda);
    List<VendaDetalhadaResponse> filtraVendas(UUID idCliente, Integer idProduto, LocalDate inicio, LocalDate fim);
    void deletaVenda(UUID idVenda);
}

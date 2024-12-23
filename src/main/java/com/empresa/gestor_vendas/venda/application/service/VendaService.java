package com.empresa.gestor_vendas.venda.application.service;

import com.empresa.gestor_vendas.venda.application.api.dto.ItemVendaRequets;
import com.empresa.gestor_vendas.venda.application.api.dto.VendaRequest;
import com.empresa.gestor_vendas.venda.application.api.dto.VendaResponse;

import java.util.UUID;

public interface VendaService {
    VendaResponse abreVenda(VendaRequest vendaRequest);
    void fechaVenda(UUID idVenda);
    void addItemVenda(ItemVendaRequets itemVendaRequets, UUID idVenda);
}

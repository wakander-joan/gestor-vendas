package com.empresa.gestor_vendas.venda.application.service;

import com.empresa.gestor_vendas.venda.application.api.dto.VendaRequest;
import com.empresa.gestor_vendas.venda.application.api.dto.VendaResponse;

public interface VendaService {
    VendaResponse abreVenda(VendaRequest vendaRequest);
}

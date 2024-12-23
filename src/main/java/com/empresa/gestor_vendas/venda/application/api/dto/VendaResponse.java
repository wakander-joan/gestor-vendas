package com.empresa.gestor_vendas.venda.application.api.dto;

import com.empresa.gestor_vendas.venda.domain.Venda;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class VendaResponse {
    private UUID idVenda;

    public VendaResponse(Venda venda) {
        this.idVenda = venda.getIdVenda();
    }
}

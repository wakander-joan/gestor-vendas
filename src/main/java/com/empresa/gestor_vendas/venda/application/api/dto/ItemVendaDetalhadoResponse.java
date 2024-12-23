package com.empresa.gestor_vendas.venda.application.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class ItemVendaDetalhadoResponse {
    private Integer idProduto;
    private String descricaoProduto;
    private BigDecimal precoProduto;
    private int quantidade;
}
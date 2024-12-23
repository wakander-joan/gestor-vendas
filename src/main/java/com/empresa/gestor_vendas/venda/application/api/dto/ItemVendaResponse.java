package com.empresa.gestor_vendas.venda.application.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemVendaResponse {
    private UUID idItemVenda;
    private Integer idProduto;
    private String descricao;
    private int quantidade;
    private BigDecimal valorProduto;
}

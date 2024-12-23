package com.empresa.gestor_vendas.venda.application.api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ItemVendaRequets {
    @NotNull
    private Integer idProduto;
    @NotNull
    @Min(value = 1, message = "A quantidade deve ser no mínimo 1")
    private int quantidade;
}

package com.empresa.gestor_vendas.venda.application.api.dto;

import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class RemoveItemRequets {
    @Min(value = 1, message = "A quantidade deve ser no mínimo 1")
    private Integer quantidadeRemovida;
    private Integer idProduto;
}

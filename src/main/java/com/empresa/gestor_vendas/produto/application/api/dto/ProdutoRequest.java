package com.empresa.gestor_vendas.produto.application.api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@ToString
public class ProdutoRequest {
    @NotBlank
    private String descricao;
    @NotNull
    private BigDecimal preco;
    @Min(0)
    private int estoque;
}

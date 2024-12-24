package com.empresa.gestor_vendas.produto.application.api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoRequest {
    @NotBlank
    private String descricao;
    @NotNull
    private BigDecimal preco;
    @Min(0)
    private int estoque;
}

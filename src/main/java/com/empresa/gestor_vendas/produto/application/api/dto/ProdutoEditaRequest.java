package com.empresa.gestor_vendas.produto.application.api.dto;

import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class ProdutoEditaRequest {
    private String descricao;
    private BigDecimal preco;
    @Min(0)
    private Integer estoque;
}

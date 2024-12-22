package com.empresa.gestor_vendas.produto.application.api.dto;

import com.empresa.gestor_vendas.produto.domain.Produto;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@ToString
public class ProdutoDetalhadoResponse {
    private Integer idProduto;
    private String descricao;
    private BigDecimal preco;
    private Integer estoque;

    public ProdutoDetalhadoResponse(Produto produto) {
        this.idProduto = produto.getIdProduto();
        this.descricao = produto.getDescricao();
        this.preco = produto.getPreco();
        this.estoque = produto.getEstoque();
    }
}

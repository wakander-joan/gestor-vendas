package com.empresa.gestor_vendas.produto.application.api.dto;

import com.empresa.gestor_vendas.produto.domain.Produto;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ProdutoResponse {
    private Integer idProduto;

    public ProdutoResponse(Produto produto) {
        this.idProduto = produto.getIdProduto();
    }
}

package com.empresa.gestor_vendas.produto.application.api.dto;

import com.empresa.gestor_vendas.cliente.application.api.dto.ClienteListResponse;
import com.empresa.gestor_vendas.produto.domain.Produto;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@ToString
public class ProdutoListResponse {
    private Integer idProduto;
    private String descricao;
    private BigDecimal preco;
    private Integer estoque;

    public ProdutoListResponse(Produto produto) {
        this.idProduto = produto.getIdProduto();
        this.descricao = produto.getDescricao();
        this.preco = produto.getPreco();
        this.estoque = produto.getEstoque();
    }

    public static List<ProdutoListResponse> converte(List<Produto> produtos) {
        return produtos
                .stream()
                .map(ProdutoListResponse::new)
                .collect(Collectors.toList());
    }
}

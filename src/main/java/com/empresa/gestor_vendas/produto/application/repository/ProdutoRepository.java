package com.empresa.gestor_vendas.produto.application.repository;

import com.empresa.gestor_vendas.produto.domain.Produto;

import java.util.List;

public interface ProdutoRepository {
    Produto salvaProduto(Produto produto);
    Produto buscaProduto(Integer idProduto);
    List<Produto> buscaTodosProduto();
}

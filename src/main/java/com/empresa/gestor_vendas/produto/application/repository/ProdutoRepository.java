package com.empresa.gestor_vendas.produto.application.repository;

import com.empresa.gestor_vendas.produto.domain.Produto;

public interface ProdutoRepository {
    Produto salvaProduto(Produto produto);
}

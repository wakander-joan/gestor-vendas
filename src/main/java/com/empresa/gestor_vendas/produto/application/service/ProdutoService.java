package com.empresa.gestor_vendas.produto.application.service;

import com.empresa.gestor_vendas.produto.application.api.dto.ProdutoRequest;
import com.empresa.gestor_vendas.produto.application.api.dto.ProdutoResponse;

public interface ProdutoService {
    ProdutoResponse cadastraProduto(ProdutoRequest produtoRequest);
}

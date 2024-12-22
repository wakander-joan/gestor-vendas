package com.empresa.gestor_vendas.produto.application.service;

import com.empresa.gestor_vendas.produto.application.api.dto.ProdutoDetalhadoResponse;
import com.empresa.gestor_vendas.produto.application.api.dto.ProdutoListResponse;
import com.empresa.gestor_vendas.produto.application.api.dto.ProdutoRequest;
import com.empresa.gestor_vendas.produto.application.api.dto.ProdutoResponse;

import java.util.List;

public interface ProdutoService {
    ProdutoResponse cadastraProduto(ProdutoRequest produtoRequest);
    ProdutoDetalhadoResponse buscaProduto(Integer idProduto);
    List<ProdutoListResponse> buscaTodosProduto();
}

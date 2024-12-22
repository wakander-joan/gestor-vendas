package com.empresa.gestor_vendas.produto.application.service;

import com.empresa.gestor_vendas.produto.application.api.dto.*;

import java.util.List;
import java.util.UUID;

public interface ProdutoService {
    ProdutoResponse cadastraProduto(ProdutoRequest produtoRequest);
    ProdutoDetalhadoResponse buscaProduto(Integer idProduto);
    List<ProdutoListResponse> buscaTodosProduto();
    void deletaProduto(Integer idProduto);
    void editaProduto(ProdutoEditaRequest produtoEditaRequest, Integer idProduto);
}

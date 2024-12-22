package com.empresa.gestor_vendas.produto.application.api;

import com.empresa.gestor_vendas.produto.application.api.dto.ProdutoDetalhadoResponse;
import com.empresa.gestor_vendas.produto.application.api.dto.ProdutoRequest;
import com.empresa.gestor_vendas.produto.application.api.dto.ProdutoResponse;
import com.empresa.gestor_vendas.produto.application.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ProdutoController implements ProdutoAPI {
    private final ProdutoService produtoService;

    @Override
    public ProdutoResponse cadastraProduto(ProdutoRequest produtoRequest) {
        log.info("[start] ProdutoController - cadastraProduto");
        ProdutoResponse produto = produtoService.cadastraProduto(produtoRequest);
        log.info("[finish] ProdutoController - cadastraProduto");
        return produto;
    }

    @Override
    public ProdutoDetalhadoResponse buscaProduto(Integer idProduto) {
        log.info("[start] ProdutoController - getProduto");
        ProdutoDetalhadoResponse produto = produtoService.buscaProduto(idProduto);
        log.info("[finish] ProdutoController - getProduto");
        return produto;
    }
}

package com.empresa.gestor_vendas.produto.application.api;

import com.empresa.gestor_vendas.produto.application.api.dto.*;
import com.empresa.gestor_vendas.produto.application.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

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
        log.info("[start] ProdutoController - buscaProduto");
        ProdutoDetalhadoResponse produto = produtoService.buscaProduto(idProduto);
        log.info("[finish] ProdutoController - buscaProduto");
        return produto;
    }

    @Override
    public List<ProdutoListResponse> buscaTodosProduto() {
        log.info("[start] ProdutoController - buscaTodosProduto");
        List<ProdutoListResponse> produtos = produtoService.buscaTodosProduto();
        log.info("[finish] ProdutoController - buscaTodosProduto");
        return produtos;
    }

    @Override
    public void deletaProduto(Integer idProduto) {
        log.info("[start] ProdutoController - deletaProduto");
        produtoService.deletaProduto(idProduto);
        log.info("[finish] ProdutoController - deletaProduto");
    }

    @Override
    public void editaProduto(ProdutoEditaRequest produtoEditaRequest, Integer idProduto) {
        log.info("[start] ProdutoController - editaProduto");
        produtoService.editaProduto(produtoEditaRequest, idProduto);
        log.info("[finish] ProdutoController - editaProduto");
    }
}

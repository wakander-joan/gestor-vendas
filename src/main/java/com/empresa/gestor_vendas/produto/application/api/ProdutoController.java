package com.empresa.gestor_vendas.produto.application.api;

import com.empresa.gestor_vendas.produto.application.api.dto.ProdutoDetalhadoResponse;
import com.empresa.gestor_vendas.produto.application.api.dto.ProdutoListResponse;
import com.empresa.gestor_vendas.produto.application.api.dto.ProdutoRequest;
import com.empresa.gestor_vendas.produto.application.api.dto.ProdutoResponse;
import com.empresa.gestor_vendas.produto.application.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}

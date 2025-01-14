package com.empresa.gestor_vendas.produto.application.service;

import com.empresa.gestor_vendas.produto.application.api.dto.*;
import com.empresa.gestor_vendas.produto.application.repository.ProdutoRepository;
import com.empresa.gestor_vendas.produto.domain.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProdutoApplicationService implements ProdutoService {
    private final ProdutoRepository produtoRepository;

    @Override
    public ProdutoResponse cadastraProduto(ProdutoRequest produtoRequest) {
        log.info("[start] ProdutoApplicationService - cadastraProduto");
        Produto produto = produtoRepository.salvaProduto(new Produto(produtoRequest));
        log.info("[finish] ProdutoApplicationService - cadastraProduto");
        return new ProdutoResponse(produto);
    }

    @Override
    public ProdutoDetalhadoResponse buscaProduto(Integer idProduto) {
        log.info("[start] ProdutoApplicationService - buscaProduto");
        Produto produto = produtoRepository.buscaProduto(idProduto);
        log.info("[finish] ProdutoApplicationService - buscaProduto");
        return new ProdutoDetalhadoResponse(produto);
    }

    @Override
    public List<ProdutoListResponse> buscaTodosProduto() {
        log.info("[start] ProdutoApplicationService - buscaTodosProduto");
        List<Produto> produtos =produtoRepository.buscaTodosProduto();
        log.info("[finish] ProdutoApplicationService - buscaTodosProduto");
        return ProdutoListResponse.converte(produtos);
    }

    @Override
    public void deletaProduto(Integer idProduto) {
        log.info("[start] ProdutoApplicationService - deletaProduto");
        produtoRepository.buscaProduto(idProduto);
        produtoRepository.deletaProduto(idProduto);
        log.info("[finish] ProdutoApplicationService - deletaProduto");
    }

    @Override
    public void editaProduto(ProdutoEditaRequest produtoEditaRequest, Integer idProduto) {
        log.info("[start] ProdutoApplicationService - editaProduto");
        Produto produto =produtoRepository.buscaProduto(idProduto);
        produto.edita(produtoEditaRequest);
        produtoRepository.salvaProduto(produto);
        log.info("[finish] ProdutoApplicationService - editaProduto");
    }
}

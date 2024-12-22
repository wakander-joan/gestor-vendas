package com.empresa.gestor_vendas.produto.infra;

import com.empresa.gestor_vendas.handler.APIException;
import com.empresa.gestor_vendas.produto.application.repository.ProdutoRepository;
import com.empresa.gestor_vendas.produto.domain.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ProdutoInfraRepository implements ProdutoRepository {
    private final ProdutoSpringDataJPARepository produtoSpringDataJPARepository;

    @Override
    public Produto salvaProduto(Produto produto) {
        log.info("[start] ProdutoInfraRepository - salvaProduto");
        produtoSpringDataJPARepository.save(produto);
        log.info("[finish] ProdutoInfraRepository - salvaProduto");
        return produto;
    }

    @Override
    public Produto buscaProduto(Integer idProduto) {
        log.info("[start] ProdutoInfraRepository - buscaProduto");
        Produto produto = produtoSpringDataJPARepository.findById(idProduto)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Produto não encontrado"));
        log.info("[finish] ProdutoInfraRepository - buscaProduto");
        return produto;
    }

    @Override
    public List<Produto> buscaTodosProduto() {
        log.info("[start] ProdutoInfraRepository - buscaTodosProduto");
        List<Produto> produtos = produtoSpringDataJPARepository.findAll();
        log.info("[finish] ProdutoInfraRepository - buscaTodosProduto");
        return produtos;
    }
}

package com.empresa.gestor_vendas.produto.infra;

import com.empresa.gestor_vendas.produto.application.repository.ProdutoRepository;
import com.empresa.gestor_vendas.produto.domain.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

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
}

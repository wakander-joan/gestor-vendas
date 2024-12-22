package com.empresa.gestor_vendas.produto.infra;

import com.empresa.gestor_vendas.produto.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoSpringDataJPARepository extends JpaRepository<Produto, Integer> {
}

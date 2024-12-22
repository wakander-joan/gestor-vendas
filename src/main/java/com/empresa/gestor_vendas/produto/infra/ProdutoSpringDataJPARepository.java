package com.empresa.gestor_vendas.produto.infra;

import com.empresa.gestor_vendas.produto.domain.Produto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProdutoSpringDataJPARepository extends JpaRepository<Produto, Integer> {
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM produto WHERE idproduto = :idProduto", nativeQuery = true)
    void deleteByIdProduto(Integer idProduto);
}

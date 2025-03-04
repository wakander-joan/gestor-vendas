package com.empresa.gestor_vendas.venda.infra;

import com.empresa.gestor_vendas.venda.domain.ItemVenda;
import com.empresa.gestor_vendas.venda.domain.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface VendaSpringDataJPARepository  extends JpaRepository<Venda, UUID>, JpaSpecificationExecutor<Venda> {
    @Query(value = "SELECT * FROM venda WHERE idcliente = :idCliente", nativeQuery = true)
    List<Venda> buscaVendasCliente(@Param("idCliente") UUID idCliente);

    @Query("SELECT i FROM ItemVenda i WHERE i.venda.idVenda = :idVenda")
    List<ItemVenda> findByIdVenda(@Param("idVenda") UUID idVenda);

    List<Venda> findByIdClienteAndDiaAberturaBetween(UUID idCliente, LocalDate inicio, LocalDate fim);
    List<Venda> findByIdClienteAndItens_IdProdutoAndDiaAberturaBetween(UUID idCliente, Integer idProduto, LocalDate inicio, LocalDate fim);

}

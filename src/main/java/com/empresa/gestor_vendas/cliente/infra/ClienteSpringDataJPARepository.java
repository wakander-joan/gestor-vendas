package com.empresa.gestor_vendas.cliente.infra;

import com.empresa.gestor_vendas.cliente.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ClienteSpringDataJPARepository extends JpaRepository<Cliente, UUID> {
    @Query(value = "SELECT * FROM cliente WHERE email = :email", nativeQuery = true)
    List<Cliente> findByEmail(@Param("email") String email);
}

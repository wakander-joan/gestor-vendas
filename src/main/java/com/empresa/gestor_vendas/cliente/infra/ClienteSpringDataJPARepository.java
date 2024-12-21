package com.empresa.gestor_vendas.cliente.infra;

import com.empresa.gestor_vendas.cliente.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClienteSpringDataJPARepository extends JpaRepository<Cliente, UUID> {
}

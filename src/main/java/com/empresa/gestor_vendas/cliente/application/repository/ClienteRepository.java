package com.empresa.gestor_vendas.cliente.application.repository;

import com.empresa.gestor_vendas.cliente.domain.Cliente;

import java.util.UUID;

public interface ClienteRepository {
    Cliente salvaCliente(Cliente cliente);
    Cliente buscaCliente(UUID idCliente);
}

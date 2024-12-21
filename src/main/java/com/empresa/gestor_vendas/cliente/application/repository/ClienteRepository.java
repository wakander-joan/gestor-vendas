package com.empresa.gestor_vendas.cliente.application.repository;

import com.empresa.gestor_vendas.cliente.domain.Cliente;

public interface ClienteRepository {
    Cliente salvaCliente(Cliente cliente);
}

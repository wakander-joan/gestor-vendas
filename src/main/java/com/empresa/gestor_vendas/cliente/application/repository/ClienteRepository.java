package com.empresa.gestor_vendas.cliente.application.repository;

import com.empresa.gestor_vendas.cliente.domain.Cliente;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;
import java.util.UUID;

public interface ClienteRepository {
    Cliente salvaCliente(Cliente cliente);
    Cliente buscaCliente(UUID idCliente);
    List<Cliente> buscaClientePorEmail(@NotBlank @Email String email);
    List<Cliente> buscaTodosClientes();
}

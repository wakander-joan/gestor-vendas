package com.empresa.gestor_vendas.cliente.infra;

import com.empresa.gestor_vendas.cliente.application.repository.ClienteRepository;
import com.empresa.gestor_vendas.cliente.domain.Cliente;
import com.empresa.gestor_vendas.handler.APIException;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ClienteInfraRepository implements ClienteRepository {
    private final ClienteSpringDataJPARepository clienteSpringDataJPARepository;

    @Override
    public Cliente salvaCliente(Cliente cliente) {
        log.info("[start] ClienteInfraRepository - cadastraCliente");
        Cliente clienteCriado = clienteSpringDataJPARepository.save(cliente);
        log.info("[finish] ClienteInfraRepository - cadastraCliente");
        return clienteCriado;
    }

    @Override
    public Cliente buscaCliente(UUID idCliente) {
        log.info("[start] ClienteInfraRepository - buscaCliente");
        Cliente cliente = clienteSpringDataJPARepository.findById(idCliente)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
        log.info("[finish] ClienteInfraRepository - buscaCliente");
        return cliente;
    }

    @Override
    public List<Cliente> buscaClientePorEmail(@NotBlank @Email String email) {
        log.info("[start] ClienteInfraRepository - buscaClientePorEmail");
        List<Cliente> clientes = clienteSpringDataJPARepository.findByEmail(email);
        log.info("[finish] ClienteInfraRepository - buscaClientePorEmail");
        return clientes;
    }

    @Override
    public List<Cliente> buscaTodosClientes() {
       log.info("[start] ClienteInfraRepository - buscaTodosClientes");
        List<Cliente> clientes = clienteSpringDataJPARepository.findAll();
       log.info("[finish] ClienteInfraRepository - buscaTodosClientes");
        return clientes;
    }
}

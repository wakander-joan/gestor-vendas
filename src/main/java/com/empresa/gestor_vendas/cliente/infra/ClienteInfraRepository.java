package com.empresa.gestor_vendas.cliente.infra;

import com.empresa.gestor_vendas.cliente.application.repository.ClienteRepository;
import com.empresa.gestor_vendas.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

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
}

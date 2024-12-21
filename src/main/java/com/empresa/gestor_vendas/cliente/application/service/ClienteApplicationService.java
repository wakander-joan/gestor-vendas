package com.empresa.gestor_vendas.cliente.application.service;

import com.empresa.gestor_vendas.cliente.application.api.dto.ClienteDetalhadoResponse;
import com.empresa.gestor_vendas.cliente.application.api.dto.ClienteRequest;
import com.empresa.gestor_vendas.cliente.application.api.dto.ClienteResponse;
import com.empresa.gestor_vendas.cliente.application.repository.ClienteRepository;
import com.empresa.gestor_vendas.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class ClienteApplicationService implements ClienteService {
    private final ClienteRepository clienteRepository;

    @Override
    public ClienteResponse cadastraCliente(ClienteRequest clienteRequest) {
        log.info("[start] ClienteApplicationService - cadastraCliente");
        Cliente clienteCriado = clienteRepository.salvaCliente(new Cliente(clienteRequest));
        log.info("[finish] ClienteApplicationService - cadastraCliente");
        return new ClienteResponse(clienteCriado);
    }

    @Override
    public ClienteDetalhadoResponse buscaCliente(UUID idCliente) {
        log.info("[start] ClienteApplicationService - buscaCliente");
        Cliente cliente = clienteRepository.buscaCliente(idCliente);
        log.info("[finish] ClienteApplicationService - buscaCliente");
        return new ClienteDetalhadoResponse(cliente);
    }
}

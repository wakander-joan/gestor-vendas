package com.empresa.gestor_vendas.cliente.application.api;

import com.empresa.gestor_vendas.cliente.application.api.dto.ClienteDetalhadoResponse;
import com.empresa.gestor_vendas.cliente.application.api.dto.ClienteListResponse;
import com.empresa.gestor_vendas.cliente.application.api.dto.ClienteRequest;
import com.empresa.gestor_vendas.cliente.application.api.dto.ClienteResponse;
import com.empresa.gestor_vendas.cliente.application.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ClienteController implements ClienteAPI {
    private final ClienteService clienteService;

    @Override
    public ClienteResponse cadastraCliente(ClienteRequest clienteRequest) {
        log.info("[start] ClienteController - cadastraCliente");
        ClienteResponse cliente = clienteService.cadastraCliente(clienteRequest);
        log.info("[finish] ClienteController - cadastraCliente");
        return cliente;
    }

    @Override
    public ClienteDetalhadoResponse buscaCliente(UUID idCliente) {
        log.info("[start] ClienteController - buscaCliente");
        ClienteDetalhadoResponse cliente =clienteService.buscaCliente(idCliente);
        log.info("[finish] ClienteController - buscaCliente");
        return cliente;
    }

    @Override
    public List<ClienteListResponse> buscaTodosClientes() {
        log.info("[start] ClienteController - buscaTodosClientes");
        List<ClienteListResponse> clientes = clienteService.buscaTodosClientes();
        log.info("[finish] ClienteController - buscaTodosClientes");
        return clientes;
    }
}

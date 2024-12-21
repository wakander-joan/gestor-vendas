package com.empresa.gestor_vendas.cliente.application.api;

import com.empresa.gestor_vendas.cliente.application.api.dto.ClienteDetalhadoResponse;
import com.empresa.gestor_vendas.cliente.application.api.dto.ClienteRequest;
import com.empresa.gestor_vendas.cliente.application.api.dto.ClienteResponse;
import com.empresa.gestor_vendas.cliente.application.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

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
    public ClienteDetalhadoResponse getCliente(UUID idCliente) {
        log.info("[start] ClienteController - getCliente");
        log.info("[finish] ClienteController - getCliente");
        return null;
    }
}

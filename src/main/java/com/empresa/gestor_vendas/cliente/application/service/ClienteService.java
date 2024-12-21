package com.empresa.gestor_vendas.cliente.application.service;

import com.empresa.gestor_vendas.cliente.application.api.dto.ClienteDetalhadoResponse;
import com.empresa.gestor_vendas.cliente.application.api.dto.ClienteRequest;
import com.empresa.gestor_vendas.cliente.application.api.dto.ClienteResponse;

import java.util.UUID;

public interface ClienteService {
    ClienteResponse cadastraCliente(ClienteRequest clienteRequest);
    ClienteDetalhadoResponse buscaCliente(UUID idCliente);
}

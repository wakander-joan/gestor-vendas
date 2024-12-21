package com.empresa.gestor_vendas.cliente.application.service;

import com.empresa.gestor_vendas.cliente.application.api.dto.ClienteRequest;
import com.empresa.gestor_vendas.cliente.application.api.dto.ClienteResponse;

public interface ClienteService {
    ClienteResponse cadastraCliente(ClienteRequest clienteRequest);
}

package com.empresa.gestor_vendas.cliente.application.service;

import com.empresa.gestor_vendas.cliente.application.api.dto.*;

import java.util.List;
import java.util.UUID;

public interface ClienteService {
    ClienteResponse cadastraCliente(ClienteRequest clienteRequest);
    ClienteDetalhadoResponse buscaCliente(UUID idCliente);
    List<ClienteListResponse> buscaTodosClientes();
    void deletaCliente(UUID idCliente);
    void editaCliente(ClienteEditaRequest clienteEditaRequest, UUID idCliente);
}

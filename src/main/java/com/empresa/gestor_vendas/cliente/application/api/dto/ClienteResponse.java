package com.empresa.gestor_vendas.cliente.application.api.dto;

import com.empresa.gestor_vendas.cliente.domain.Cliente;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class ClienteResponse {
    private UUID idCliente;

    public ClienteResponse(Cliente clienteCriado) {
        this.idCliente = clienteCriado.getIdCliente();
    }
}

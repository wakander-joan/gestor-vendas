package com.empresa.gestor_vendas.cliente.application.api.dto;

import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class ClienteResponse {
    private UUID idCliente;
}

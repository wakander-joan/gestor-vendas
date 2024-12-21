package com.empresa.gestor_vendas.cliente.application.api.dto;

import com.empresa.gestor_vendas.cliente.domain.Cliente;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@ToString
public class ClienteListResponse {
    private UUID idCliente;
    private String nome;

    public static List<ClienteListResponse> converte(List<Cliente> clientes) {
        return clientes.stream().map(ClienteListResponse::new).collect(Collectors.toList());
    }

    public ClienteListResponse(Cliente cliente) {
        this.idCliente = cliente.getIdCliente();
        this.nome = cliente.getNome();
    }
}

package com.empresa.gestor_vendas.cliente.application.api.dto;


import com.empresa.gestor_vendas.cliente.domain.Cliente;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@ToString
public class ClienteDetalhadoResponse {
    private UUID idCliente;
    private String nome;
    private String email;
    private BigDecimal limiteCompra;
    private Integer diaFechamento;

    public ClienteDetalhadoResponse(Cliente cliente) {
        this.idCliente = cliente.getIdCliente();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.limiteCompra = cliente.getLimiteCompra();
        this.diaFechamento = cliente.getDiaFechamento();
    }
}

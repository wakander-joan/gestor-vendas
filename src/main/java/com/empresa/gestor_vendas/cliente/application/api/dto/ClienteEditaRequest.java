package com.empresa.gestor_vendas.cliente.application.api.dto;

import jakarta.validation.constraints.Email;

import java.math.BigDecimal;

public class ClienteEditaRequest {
    private String nome;
    @Email
    private String email;
    private BigDecimal limiteCompra;
    private Integer diaFechamento;
}

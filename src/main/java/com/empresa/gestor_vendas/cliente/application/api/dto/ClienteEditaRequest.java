package com.empresa.gestor_vendas.cliente.application.api.dto;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@ToString
@AllArgsConstructor
public class ClienteEditaRequest {
    private String nome;
    @Email
    private String email;
    private BigDecimal limiteCompra;
    private Integer diaFechamento;
}

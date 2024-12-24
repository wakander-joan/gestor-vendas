package com.empresa.gestor_vendas.cliente.application.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@ToString
@AllArgsConstructor
public class ClienteRequest {
    @NotBlank
    private String nome;
    @NotBlank
    @Email
    private String email;
    @NotNull
    private BigDecimal limiteCompra;
    @NotNull
    private Integer diaFechamento;
}

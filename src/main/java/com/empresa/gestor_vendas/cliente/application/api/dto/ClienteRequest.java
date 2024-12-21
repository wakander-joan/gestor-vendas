package com.empresa.gestor_vendas.cliente.application.api.dto;

import com.empresa.gestor_vendas.util.json.DiaDoMesFormate;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@ToString
public class ClienteRequest {
    @NotBlank
    private String nome;
    @NotBlank
    @Email
    private String email;
    @NotNull
    private BigDecimal limiteCompra;
    @NotNull
    @JsonSerialize(using = DiaDoMesFormate.class)
    private LocalDate diaFechamento;
}

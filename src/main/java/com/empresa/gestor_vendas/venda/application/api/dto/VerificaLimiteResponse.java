package com.empresa.gestor_vendas.venda.application.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VerificaLimiteResponse {
    private boolean limiteExcedido;
    private BigDecimal totalCompraAtual;
    private BigDecimal totalComprasAposFechamento;
    private BigDecimal saldoDisponivel;
    private LocalDate proximoFechamento;
    private String mensagem;
}

package com.empresa.gestor_vendas.cliente.domain;

import com.empresa.gestor_vendas.cliente.application.api.dto.ClienteRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@ToString
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID idCliente;
    @NotBlank
    private String nome;
    @NotBlank
    @Email
    @Column(unique = true, nullable = false)
    private String email;
    @NotNull
    private BigDecimal limiteCompra;
    @NotNull
    private Integer diaFechamento;

    public Cliente(ClienteRequest clienteRequest) {
        this.nome = clienteRequest.getNome();
        this.email = clienteRequest.getEmail();
        this.limiteCompra = clienteRequest.getLimiteCompra();
        this.diaFechamento = clienteRequest.getDiaFechamento();
    }
}

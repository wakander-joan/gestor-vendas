package com.empresa.gestor_vendas.venda.application.api.dto;

import com.empresa.gestor_vendas.venda.domain.ItemVenda;
import com.empresa.gestor_vendas.venda.domain.StatusVenda;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@ToString
public class VendaRequest {
    @NotNull
    private UUID idCliente;
    private List<ItemVenda> itens;
}

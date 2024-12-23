package com.empresa.gestor_vendas.venda.application.api;

import com.empresa.gestor_vendas.venda.application.api.dto.ItemVendaDetalhadoResponse;
import com.empresa.gestor_vendas.venda.application.api.dto.ItemVendaResponse;
import com.empresa.gestor_vendas.venda.domain.ItemVenda;
import com.empresa.gestor_vendas.venda.domain.StatusVenda;
import com.empresa.gestor_vendas.venda.domain.Venda;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@ToString
public class VendaDetalhadaResponse {
    private UUID idVenda;
    private BigDecimal valorTotal;
    private LocalDateTime diaAbertura;
    private UUID idCliente;
    private StatusVenda statusVenda;
    private List<ItemVendaDetalhadoResponse> itens;

    public VendaDetalhadaResponse(Venda venda, List<ItemVendaDetalhadoResponse> itensDetalhados) {
        this.idVenda = venda.getIdVenda();
        this.valorTotal = venda.getValorTotal();
        this.diaAbertura = venda.getDiaAbertura();
        this.idCliente = venda.getIdCliente();
        this.statusVenda = venda.getStatusVenda();
        this.itens = itensDetalhados;
    }
}

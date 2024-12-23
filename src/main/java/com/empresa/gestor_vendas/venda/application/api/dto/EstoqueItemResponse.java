package com.empresa.gestor_vendas.venda.application.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EstoqueItemResponse {
    private final int idProduto;
    private final int estoqueDisponivel;
    private final int quantidadeSolicitada;
    private final boolean temEstoqueSuficiente;
    private final String mensagem;
}

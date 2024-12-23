package com.empresa.gestor_vendas.venda.application.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
public class VerificaEstoqueResponse {
    private final boolean todosItensDisponiveis;
    private final List<EstoqueItemResponse> itens;
    private final String mensagem;

    public VerificaEstoqueResponse(boolean todosItensDisponiveis, List<EstoqueItemResponse> itensResposta, String mensagemFinal) {
        this.todosItensDisponiveis = todosItensDisponiveis;
        this.itens = itensResposta;
        this.mensagem = mensagemFinal;
    }
}

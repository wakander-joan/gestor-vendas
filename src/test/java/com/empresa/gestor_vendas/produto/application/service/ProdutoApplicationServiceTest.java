package com.empresa.gestor_vendas.produto.application.service;

import com.empresa.gestor_vendas.produto.application.api.dto.ProdutoRequest;
import com.empresa.gestor_vendas.produto.application.api.dto.ProdutoResponse;
import com.empresa.gestor_vendas.produto.application.repository.ProdutoRepository;
import com.empresa.gestor_vendas.produto.domain.Produto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProdutoApplicationServiceTest {

    @Mock
    private ProdutoRepository produtoRepository;

    @InjectMocks
    private ProdutoApplicationService produtoApplicationService;

    @Test
    void deveCadastrarProdutoComSucesso() {
        // Dado que
        ProdutoRequest produtoRequest = new ProdutoRequest();
        produtoRequest.setDescricao("Produto A");
        produtoRequest.setPreco(new BigDecimal("10.00"));
        produtoRequest.setEstoque(5);

        Produto produto = Produto.builder()
                .idProduto(1)
                .descricao(produtoRequest.getDescricao())
                .preco(produtoRequest.getPreco())
                .estoque(produtoRequest.getEstoque())
                .build();

        when(produtoRepository.salvaProduto(any(Produto.class))).thenReturn(produto);

        // Faça
        ProdutoResponse produtoResponse = produtoApplicationService.cadastraProduto(produtoRequest);

        // Verifica
        assertNotNull(produtoResponse);
        assertEquals(1, produtoResponse.getIdProduto());
        verify(produtoRepository).salvaProduto(any(Produto.class));
    }

}


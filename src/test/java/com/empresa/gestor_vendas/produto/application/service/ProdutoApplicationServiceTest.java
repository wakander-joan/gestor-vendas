package com.empresa.gestor_vendas.produto.application.service;

import com.empresa.gestor_vendas.produto.application.api.dto.ProdutoDetalhadoResponse;
import com.empresa.gestor_vendas.produto.application.api.dto.ProdutoListResponse;
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
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
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

    @Test
    void deveBuscarProdutoComSucesso() {
        // Dado que
        Produto produto = Produto.builder()
                .idProduto(1)
                .descricao("Produto A")
                .preco(new BigDecimal("10.00"))
                .estoque(5)
                .build();

        when(produtoRepository.buscaProduto(1)).thenReturn(produto);

        // Faça
        ProdutoDetalhadoResponse produtoDetalhadoResponse = produtoApplicationService.buscaProduto(1);

        // Verifica
        assertNotNull(produtoDetalhadoResponse);
        assertEquals(1, produtoDetalhadoResponse.getIdProduto());
        assertEquals("Produto A", produtoDetalhadoResponse.getDescricao());
        verify(produtoRepository).buscaProduto(1);
    }

    @Test
    void deveBuscarTodosProdutosComSucesso() {
        // Dado que
        Produto produto = Produto.builder()
                .idProduto(1)
                .descricao("Produto A")
                .preco(new BigDecimal("10.00"))
                .estoque(5)
                .build();

        when(produtoRepository.buscaTodosProduto()).thenReturn(Collections.singletonList(produto));

        // Faça
        List<ProdutoListResponse> produtoListResponses = produtoApplicationService.buscaTodosProduto();

        // Verifica
        assertNotNull(produtoListResponses);
        assertFalse(produtoListResponses.isEmpty());
        assertEquals(1, produtoListResponses.size());
        verify(produtoRepository).buscaTodosProduto();
    }

    @Test
    void deveDeletarProdutoComSucesso() {
        // Dado que
        Produto produto = Produto.builder()
                .idProduto(1)
                .descricao("Produto A")
                .preco(new BigDecimal("10.00"))
                .estoque(5)
                .build();

        when(produtoRepository.buscaProduto(1)).thenReturn(produto);

        // Faça
        produtoApplicationService.deletaProduto(1);

        // Verifica
        verify(produtoRepository).buscaProduto(1);
        verify(produtoRepository).deletaProduto(1);
    }

}


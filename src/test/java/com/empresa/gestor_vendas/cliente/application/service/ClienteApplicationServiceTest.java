package com.empresa.gestor_vendas.cliente.application.service;

import com.empresa.gestor_vendas.cliente.application.api.dto.*;
import com.empresa.gestor_vendas.cliente.application.repository.ClienteRepository;
import com.empresa.gestor_vendas.cliente.domain.Cliente;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClienteApplicationServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteApplicationService clienteApplicationService;

    @Test
    void CadastraClienteComSucesso() {
        // Dado que
        ClienteRequest clienteRequest = new ClienteRequest("João", "joao@gmail.com", new BigDecimal("1000.00"), 10);
        Cliente clienteMock = new Cliente(clienteRequest);
        when(clienteRepository.salvaCliente(any(Cliente.class))).thenReturn(clienteMock);

        // Faça
        ClienteResponse clienteResponse = clienteApplicationService.cadastraCliente(clienteRequest);

        // Verifique
        assertNotNull(clienteResponse);
        assertEquals(clienteMock.getIdCliente(), clienteResponse.getIdCliente());
        verify(clienteRepository, times(1)).salvaCliente(any(Cliente.class));
    }

    @Test
    void verificaRetornoClienteDetalhadoComSucesso() {
        // Arrange
        UUID idCliente = UUID.randomUUID();
        Cliente clienteMock = new Cliente(idCliente, "João", "joao@gmail.com", new BigDecimal("1000.00"), 10);
        when(clienteRepository.buscaCliente(idCliente)).thenReturn(clienteMock);

        // Act
        ClienteDetalhadoResponse response = clienteApplicationService.buscaCliente(idCliente);

        // Assert
        assertNotNull(response);
        assertEquals("João", response.getNome());
        assertEquals("joao@gmail.com", response.getEmail());
        assertEquals(new BigDecimal("1000.00"), response.getLimiteCompra());
        assertEquals(10, response.getDiaFechamento());
        verify(clienteRepository, times(1)).buscaCliente(idCliente);
    }

}

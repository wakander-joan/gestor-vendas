package com.empresa.gestor_vendas.cliente.application.service;

import com.empresa.gestor_vendas.cliente.application.api.dto.ClienteDetalhadoResponse;
import com.empresa.gestor_vendas.cliente.application.api.dto.ClienteListResponse;
import com.empresa.gestor_vendas.cliente.application.api.dto.ClienteRequest;
import com.empresa.gestor_vendas.cliente.application.api.dto.ClienteResponse;
import com.empresa.gestor_vendas.cliente.application.repository.ClienteRepository;
import com.empresa.gestor_vendas.cliente.domain.Cliente;
import com.empresa.gestor_vendas.handler.APIException;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class ClienteApplicationService implements ClienteService {
    private final ClienteRepository clienteRepository;

    @Override
    public ClienteResponse cadastraCliente(ClienteRequest clienteRequest) {
        log.info("[start] ClienteApplicationService - cadastraCliente");
        verificaEmail(clienteRequest.getEmail());
        Cliente clienteCriado = clienteRepository.salvaCliente(new Cliente(clienteRequest));
        log.info("[finish] ClienteApplicationService - cadastraCliente");
        return new ClienteResponse(clienteCriado);
    }

    @Override
    public ClienteDetalhadoResponse buscaCliente(UUID idCliente) {
        log.info("[start] ClienteApplicationService - buscaCliente");
        Cliente cliente = clienteRepository.buscaCliente(idCliente);
        log.info("[finish] ClienteApplicationService - buscaCliente");
        return new ClienteDetalhadoResponse(cliente);
    }

    @Override
    public List<ClienteListResponse> buscaTodosClientes() {
        log.info("[start] ] - buscaTodosClientes");
        List<Cliente> clientes = clienteRepository.buscaTodosClientes();
        log.info("[finish] ] - buscaTodosClientes");
        return ClienteListResponse.converte(clientes);
    }

    @Override
    public void deletaCliente(UUID idCliente) {
        log.info("[start] ClienteApplicationService - deletaCliente");
        buscaCliente(idCliente);
        clienteRepository.deletaCliente(idCliente);
        log.info("[finish] ClienteApplicationService - deletaCliente");
    }

    @Override
    public void editaCliente(UUID idCliente) {
        log.info("[start] ClienteApplicationService - editaCliente");
        log.info("[finish] ClienteApplicationService - editaCliente");
    }

    //Metodo para impedir a duplicidade de um Cliente
    private void verificaEmail(@NotBlank @Email String email) {
        List<Cliente> clientes = clienteRepository.buscaClientePorEmail(email);
        boolean emailEncontrado = clientes.stream()
                .anyMatch(cliente -> cliente.getEmail().equals(email));
        if (emailEncontrado) {
            throw APIException.build(HttpStatus.NOT_FOUND, "Email já cadastrado!");
        } else {
            log.info("[ Email verificado! ]");
        }
    }

}

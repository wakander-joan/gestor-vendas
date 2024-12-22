package com.empresa.gestor_vendas.cliente.application.api;

import com.empresa.gestor_vendas.cliente.application.api.dto.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping ("/cliente")
public interface ClienteAPI {

    @PostMapping("/cadastraCliente")
    @ResponseStatus(code = HttpStatus.CREATED)
    ClienteResponse cadastraCliente (@Valid @RequestBody ClienteRequest clienteRequest);

    @GetMapping("/buscaCliente/{idCliente}")
    @ResponseStatus(code = HttpStatus.OK)
    ClienteDetalhadoResponse buscaCliente (@PathVariable UUID idCliente);

    @GetMapping("/buscaTodosClientes")
    @ResponseStatus(code = HttpStatus.OK)
    List<ClienteListResponse> buscaTodosClientes();

    @DeleteMapping(value = "/deletaCliente/{idCliente}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletaCliente(@PathVariable UUID idCliente);

    @PatchMapping("/editaCliente/{idCliente}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void editaCliente(@Valid @RequestBody ClienteEditaRequest clienteEditaRequest, @PathVariable UUID idCliente);
}

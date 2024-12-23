package com.empresa.gestor_vendas.venda.application.api;

import com.empresa.gestor_vendas.venda.application.api.dto.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/venda")
public interface VendaAPI {

    @PostMapping("/abreVenda")
    @ResponseStatus(code = HttpStatus.CREATED)
    VendaResponse abreVenda (@Valid @RequestBody VendaRequest vendaRequest);

    @PatchMapping("/fechaVenda/{idVenda}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void fechaVenda( @PathVariable UUID idVenda);

    @PostMapping("/addItemVenda/{idVenda}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void addItemVenda (@Valid @RequestBody ItemVendaRequets itemVendaRequets, @PathVariable UUID idVenda);

    @DeleteMapping("/removeItemVenda/{idVenda}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void removeItemVenda (@Valid @RequestBody RemoveItemRequets removeItemRequets, @PathVariable UUID idVenda);

    @GetMapping("/buscaVenda/{idVenda}")
    @ResponseStatus(code = HttpStatus.OK)
    VendaDetalhadaResponse buscaVenda (@PathVariable UUID idVenda);

}

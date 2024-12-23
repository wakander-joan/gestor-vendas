package com.empresa.gestor_vendas.venda.application.api;

import com.empresa.gestor_vendas.venda.application.api.dto.*;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
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

    @GetMapping("/filtro")
    @ResponseStatus(code = HttpStatus.OK)
    List<VendaDetalhadaResponse> filtraVendas(
            @RequestParam(required = false) UUID idCliente,
            @RequestParam(required = false) Integer idProduto,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim
    );

    @DeleteMapping("/deletaVenda/{idVenda}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletaVenda (@PathVariable UUID idVenda);

}

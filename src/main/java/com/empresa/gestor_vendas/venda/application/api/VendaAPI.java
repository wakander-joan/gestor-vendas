package com.empresa.gestor_vendas.venda.application.api;

import com.empresa.gestor_vendas.venda.application.api.dto.VendaRequest;
import com.empresa.gestor_vendas.venda.application.api.dto.VendaResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/venda")
public interface VendaAPI {

    @PostMapping("/abreVenda")
    @ResponseStatus(code = HttpStatus.CREATED)
    VendaResponse abreVenda (@Valid @RequestBody VendaRequest vendaRequest);

}

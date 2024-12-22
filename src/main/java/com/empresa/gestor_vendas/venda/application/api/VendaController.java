package com.empresa.gestor_vendas.venda.application.api;

import com.empresa.gestor_vendas.venda.application.api.dto.VendaRequest;
import com.empresa.gestor_vendas.venda.application.api.dto.VendaResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class VendaController implements VendaAPI {
    
    @Override
    public VendaResponse abreVenda(VendaRequest vendaRequest) {
        log.info("[start] VendaController - abreVenda");
        log.info("[finish] VendaController - abreVenda");
        return null;
    }
}

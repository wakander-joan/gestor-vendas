package com.empresa.gestor_vendas.venda.application.api;

import com.empresa.gestor_vendas.venda.application.api.dto.ItemVendaRequets;
import com.empresa.gestor_vendas.venda.application.api.dto.RemoveItemRequets;
import com.empresa.gestor_vendas.venda.application.api.dto.VendaRequest;
import com.empresa.gestor_vendas.venda.application.api.dto.VendaResponse;
import com.empresa.gestor_vendas.venda.application.service.VendaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class VendaController implements VendaAPI {
    private final VendaService vendaService;
    
    @Override
    public VendaResponse abreVenda(VendaRequest vendaRequest) {
        log.info("[start] VendaController - abreVenda");
        VendaResponse venda = vendaService.abreVenda(vendaRequest);
        log.info("[finish] VendaController - abreVenda");
        return venda;
    }

    @Override
    public void fechaVenda(UUID idVenda) {
        log.info("[start] VendaController - fechaVenda");
        vendaService.fechaVenda(idVenda);
        log.info("[finish] VendaController - fechaVenda");
    }

    @Override
    public void addItemVenda(ItemVendaRequets itemVendaRequets, UUID idVenda) {
        log.info("[start] VendaController - addItemVenda");
        vendaService.addItemVenda(itemVendaRequets, idVenda);
        log.info("[finish] VendaController - addItemVenda");
    }

    @Override
    public void removeItemVenda(RemoveItemRequets removeItemRequets, UUID idVenda) {
        log.info("[start] VendaController - removeItemVenda");
        vendaService.removeItemVenda(removeItemRequets, idVenda);
        log.info("[finish] VendaController - removeItemVenda");
    }

    @Override
    public VendaDetalhadaResponse buscaVenda(UUID idVenda) {
        log.info("[start] VendaController - buscaVenda");
        VendaDetalhadaResponse venda = vendaService.buscaVenda(idVenda);
        log.info("[finish] VendaController - buscaVenda");
        return venda;
    }

    @Override
    public List<VendaDetalhadaResponse> filtraVendas(UUID idCliente, Integer idProduto, LocalDate inicio, LocalDate fim) {
        log.info("[start] VendaController - filtraVendas");
        List<VendaDetalhadaResponse> vendasFiltradas = vendaService.filtraVendas(idCliente, idProduto, inicio, fim);
        log.info("[finish] VendaController - filtraVendas");
        return vendasFiltradas;
    }

    @Override
    public void deletaVenda(UUID idVenda) {
        log.info("[start] VendaController - deletaVenda");
        vendaService.deletaVenda(idVenda);
        log.info("[finish] VendaController - deletaVenda");
    }

    @Override
    public void alteraQuantidadeItem(ItemVendaRequets itemVendaRequets, UUID idVenda) {
        log.info("[start] VendaController - alteraQuantidadeItem");
        vendaService.alteraQuantidadeItem(itemVendaRequets,idVenda);
        log.info("[finish] VendaController - alteraQuantidadeItem");
    }
}

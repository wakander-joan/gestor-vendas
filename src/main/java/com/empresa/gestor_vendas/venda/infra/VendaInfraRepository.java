package com.empresa.gestor_vendas.venda.infra;

import com.empresa.gestor_vendas.handler.APIException;
import com.empresa.gestor_vendas.venda.application.repository.VendaRepository;
import com.empresa.gestor_vendas.venda.domain.Venda;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class VendaInfraRepository implements VendaRepository {
    private final VendaSpringDataJPARepository vendaSpringDataJPARepository;

    @Override
    public void salva(Venda vendaCriada) {
        log.info("[start] VendaInfraRepository - salva");
        vendaSpringDataJPARepository.save(vendaCriada);
        log.info("[finish] VendaInfraRepository - salva");
    }

    @Override
    public List<Venda> buscaVendasCliente(UUID idCliente) {
        log.info("[start] VendaInfraRepository - buscaVendasCliente");
        List<Venda> vendas = vendaSpringDataJPARepository.buscaVendasCliente(idCliente);
        log.info("[finish] VendaInfraRepository - buscaVendasCliente");
        return vendas;
    }

    @Override
    public Venda buscaVenda(UUID idVenda) {
        log.info("[start] VendaInfraRepository - buscaVenda");
        Venda venda = vendaSpringDataJPARepository.findById(idVenda)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Venda não encontrada!"));
        log.info("[finish] VendaInfraRepository - buscaVenda");
        return venda;
    }
}

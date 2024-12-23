package com.empresa.gestor_vendas.venda.domain;

import com.empresa.gestor_vendas.venda.application.api.dto.VendaRequest;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID idVenda;
    private BigDecimal valorTotal;
    @Column( updatable = false, nullable = false)
    private LocalDateTime diaAbertura;
    private UUID idCliente;
    private StatusVenda statusVenda;
    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemVenda> itens;

    public static Venda criaVenda (VendaRequest vendaRequest, BigDecimal totalCompra){
        Venda venda = new Venda();
        venda.setIdCliente(UUID.fromString(String.valueOf(vendaRequest.getIdCliente())));
        venda.setDiaAbertura(LocalDateTime.now());
        venda.setValorTotal(totalCompra);
        venda.setStatusVenda(StatusVenda.ABERTA);
        return venda.adicionaItenIniciais(venda, vendaRequest);
    }

    private Venda adicionaItenIniciais(Venda venda, VendaRequest vendaRequest) {
        List<ItemVenda> itens = vendaRequest.getItens().stream()
                .map(itemDoCarrinhoRequest -> {
                    ItemVenda item = new ItemVenda();
                    item.setQuantidade(itemDoCarrinhoRequest.getQuantidade());
                    item.setIdProduto(itemDoCarrinhoRequest.getIdProduto());
                    item.setVenda(venda);
                    return item;
                })
                .collect(Collectors.toList());

        venda.setItens(itens);
        return venda;
    }

}

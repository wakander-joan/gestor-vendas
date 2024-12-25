package com.empresa.gestor_vendas.venda.domain;

import com.empresa.gestor_vendas.venda.application.api.dto.VendaRequest;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
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

    public void fecha() {
        this.statusVenda = StatusVenda.FECHADA;
    }

    public void addItemVenda(ItemVenda item) {
        itens.add(item);
    }

    public void atualizaTotal(@NotNull BigDecimal preco) {
        this.valorTotal = valorTotal.add(preco);
    }

    public void removeItem(ItemVenda item) {
        itens.remove(item);
    }

    public void atualizaTotalSubtraindo(@NotNull BigDecimal preco) {
        this.valorTotal = this.valorTotal.subtract(preco);
    }

    public void alteraQuantidadeItemVenda(Integer idProduto, int novaQuantidade) {
        // Encontra o item correspondente ao idProduto
        ItemVenda itemEncontrado = this.itens.stream()
                .filter(item -> item.getIdProduto().equals(idProduto))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Item com o produto fornecido não encontrado na venda."));

        itemEncontrado.setQuantidade(novaQuantidade);
    }
}

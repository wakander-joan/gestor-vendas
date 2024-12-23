package com.empresa.gestor_vendas.venda.domain;

import com.empresa.gestor_vendas.produto.domain.Produto;
import com.empresa.gestor_vendas.venda.application.api.dto.ItemVendaRequets;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ItemVenda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID idItemVenda;

    @Column(columnDefinition = "INTEGER", nullable = false)
    private Integer idProduto;
    @Min(value = 1, message = "A quantidade deve ser no mínimo 1")
    @Column(nullable = false)
    private int quantidade;
    @ManyToOne
    @JoinColumn(name = "id_venda", nullable = false)
    @JsonBackReference
    private Venda venda;

    public static ItemVenda cria(ItemVendaRequets itemVendaRequets, Produto produto, Venda venda) {
        ItemVenda item = new ItemVenda();
        item.setIdProduto(produto.getIdProduto());
        item.setQuantidade(itemVendaRequets.getQuantidade());
        item.setVenda(venda);
        return item;
    }
}

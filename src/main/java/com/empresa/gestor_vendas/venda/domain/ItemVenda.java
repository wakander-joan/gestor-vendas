package com.empresa.gestor_vendas.venda.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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

    @Column(columnDefinition = "UUID", nullable = false)
    private UUID idProduto;
    @Column(nullable = false)
    private int quantidade;
    @ManyToOne
    @JoinColumn(name = "id_venda", nullable = false)
    @JsonIgnore
    private Venda venda;
}

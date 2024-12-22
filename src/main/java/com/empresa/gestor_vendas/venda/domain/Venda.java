package com.empresa.gestor_vendas.venda.domain;

import com.empresa.gestor_vendas.venda.application.api.dto.VendaRequest;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
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
    private LocalDateTime diaVenda;
    private UUID idCliente;
    private StatusVenda statusVenda;
    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemVenda> itens;

    public Venda(VendaRequest vendaRequest) {
        this.diaAbertura = LocalDateTime.now();
        this.idCliente = vendaRequest.getIdCliente();
        this.statusVenda = StatusVenda.ABERTA;
    }
}

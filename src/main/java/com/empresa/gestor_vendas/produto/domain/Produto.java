package com.empresa.gestor_vendas.produto.domain;

import com.empresa.gestor_vendas.produto.application.api.dto.ProdutoRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@ToString
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_seq")
    @SequenceGenerator(name = "produto_seq", sequenceName = "produto_sequence", allocationSize = 1)
    private Integer idProduto;
    @NotBlank
    private String descricao;
    @NotNull
    private BigDecimal preco;
    @Min(0)
    private Integer estoque;

    public Produto(ProdutoRequest produtoRequest) {
        this.descricao = produtoRequest.getDescricao();
        this.preco = produtoRequest.getPrecoProduto();
        this.estoque = produtoRequest.getEstoque();
    }
}

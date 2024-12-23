package com.empresa.gestor_vendas.venda.specification;
import com.empresa.gestor_vendas.venda.domain.Venda;
import com.empresa.gestor_vendas.venda.domain.ItemVenda;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;


import java.time.LocalDate;
import java.util.UUID;

public class VendaSpecification {

    public static Specification<Venda> filtraVendas(UUID idCliente, Integer idProduto, LocalDate inicio, LocalDate fim) {
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction(); // Começa com uma condição verdadeira (AND)

            if (idCliente != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("idCliente"), idCliente));
            }

            if (idProduto != null) {
                Join<Venda, ItemVenda> itemVenda = root.join("itens", JoinType.LEFT);
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(itemVenda.get("idProduto"), idProduto));
            }

            if (inicio != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThanOrEqualTo(root.get("diaAbertura"), inicio.atStartOfDay()));
            }

            if (fim != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.lessThanOrEqualTo(root.get("diaAbertura"), fim.atTime(23, 59, 59)));
            }

            return predicate;
        };
    }
}
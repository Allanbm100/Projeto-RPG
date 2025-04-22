package br.com.fiap.projeto_rpg.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import br.com.fiap.projeto_rpg.model.Personagem;
import br.com.fiap.projeto_rpg.model.PersonagemFilter;
import jakarta.persistence.criteria.Predicate;

public class PersonagemSpecification {

    public static Specification<Personagem> withFilters(PersonagemFilter filter) {

        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.nome() != null) {
                predicates.add(cb.like(
                        cb.lower(root.get("nome")),
                        "%" + filter.nome().toLowerCase() + "%"));
            }

            if (filter.classe() != null) {
                predicates.add(cb.like(
                        cb.lower(root.get("classe")),
                        "%" + filter.classe() + "%"));
            }

            var arrayPredicates = predicates.toArray(new Predicate[0]);
            return cb.and(arrayPredicates);
        };

    }

}

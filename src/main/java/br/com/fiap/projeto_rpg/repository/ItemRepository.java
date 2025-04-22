package br.com.fiap.projeto_rpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.projeto_rpg.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}

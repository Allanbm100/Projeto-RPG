package br.com.fiap.projeto_rpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.projeto_rpg.model.Personagem;

public interface PersonagemRepository extends JpaRepository<Personagem, Long> {

}

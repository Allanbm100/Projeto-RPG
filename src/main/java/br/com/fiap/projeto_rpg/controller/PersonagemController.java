package br.com.fiap.projeto_rpg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.projeto_rpg.model.Personagem;
import br.com.fiap.projeto_rpg.repository.PersonagemRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/personagem")
public class PersonagemController {

    @Autowired
    private PersonagemRepository repository;

    @GetMapping
    public List<Personagem> index() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Personagem create(@RequestBody @Valid Personagem Personagem) {
        log.info("Cadastrando personagem " + Personagem.getNome());
        return repository.save(Personagem);
    }

    @GetMapping("{id}")
    public Personagem get(@PathVariable Long id) {
        log.info("Buscando personagem " + id);
        return getPersonagem(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        log.info("Apagando personagem " + id);
        repository.delete(getPersonagem(id));
    }

    @PutMapping("{id}")
    @CacheEvict(allEntries = true)
    public Personagem update(@PathVariable Long id, @RequestBody Personagem personagem) {
        log.info("Atualizando personagem " + personagem.toString());

        getPersonagem(id);
        personagem.setId(id);
        repository.save(personagem);

        return personagem;
    }

    private Personagem getPersonagem(Long id) {
        return repository
                .findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Personagem não encontrado, id=" + id));
    }
}

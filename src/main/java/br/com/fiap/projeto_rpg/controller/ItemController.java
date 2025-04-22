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

import br.com.fiap.projeto_rpg.model.Item;
import br.com.fiap.projeto_rpg.repository.ItemRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/itens")
public class ItemController {

    @Autowired
    private ItemRepository repository;

    @GetMapping
    public List<Item> index() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Item create(@RequestBody @Valid Item item) {
        log.info("Cadastrando item " + item.getNome());
        return repository.save(item);
    }

    @GetMapping("{id}")
    public Item get(@PathVariable Long id) {
        log.info("Buscando item " + id);
        return getItem(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        log.info("Apagando item " + id);
        repository.delete(getItem(id));
    }

    @PutMapping("{id}")
    @CacheEvict(allEntries = true)
    public Item update(@PathVariable Long id, @RequestBody Item item) {
        log.info("Atualizando item " + item.toString());

        getItem(id);
        item.setId(id);
        repository.save(item);

        return item;
    }

    private Item getItem(Long id) {
        return repository
                .findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item não encontrado, id=" + id));
    }
}

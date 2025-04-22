package br.com.fiap.projeto_rpg.model;

import java.math.BigDecimal;

public record ItemFilter(String nome, ItemTipo tipo, BigDecimal preco, ItemRaridade raridade) {

}

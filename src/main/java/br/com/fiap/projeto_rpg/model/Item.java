package br.com.fiap.projeto_rpg.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    public String nome;

    @NotNull
    @Enumerated(EnumType.STRING)
    public ItemTipo tipo;

    @NotNull
    @Enumerated(EnumType.STRING)
    public ItemRaridade raridade;

    @Min(value = 0)
    public BigDecimal preco;

    public Personagem dono;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ItemTipo getTipo() {
        return tipo;
    }

    public void setTipo(ItemTipo tipo) {
        this.tipo = tipo;
    }

    public ItemRaridade getRaridade() {
        return raridade;
    }

    public void setRaridade(ItemRaridade raridade) {
        this.raridade = raridade;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Personagem getDono() {
        return dono;
    }

    public void setDono(Personagem dono) {
        this.dono = dono;
    }

    @Override
    public String toString() {
        return "Item [id=" + id + ", nome=" + nome + ", tipo=" + tipo + ", raridade=" + raridade + ", preco=" + preco
                + ", dono=" + dono + "]";
    }

}

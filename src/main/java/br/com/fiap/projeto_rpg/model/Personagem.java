package br.com.fiap.projeto_rpg.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
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
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    public String nome;

    @NotNull
    @Enumerated(EnumType.STRING)
    public PersonagemClasse classe;

    @Min(value = 1)
    @Max(value = 99)
    public int nivel;

    @Min(value = 0)
    public BigDecimal moedas;

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

    public PersonagemClasse getClasse() {
        return classe;
    }

    public void setClasse(PersonagemClasse classe) {
        this.classe = classe;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public BigDecimal getMoedas() {
        return moedas;
    }

    public void setMoedas(BigDecimal moedas) {
        this.moedas = moedas;
    }

    @Override
    public String toString() {
        return "Personagem [id=" + id + ", nome=" + nome + ", classe=" + classe + ", nivel=" + nivel + ", moedas="
                + moedas + "]";
    }

}

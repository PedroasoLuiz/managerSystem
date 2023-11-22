package com.bodyHealth.managerSystem.model.bodySystem;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float peso;
    private float altura;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private String nome;

    public Aluno() {
    }

    public Aluno(float peso, float altura, String Nome) {
        this.peso = peso;
        this.altura = altura;
        this.nome = Nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public Aluno(DadosAluno dados) {
        this.peso = dados.peso();
        this.altura = dados.altura();
        this.nome = dados.nome();
    }

    public void AtualizarAluno(DadosAlterarAluno dados) {
        this.peso = dados.peso();
        this.altura = dados.altura();
        this.nome = dados.nome();
    }
}

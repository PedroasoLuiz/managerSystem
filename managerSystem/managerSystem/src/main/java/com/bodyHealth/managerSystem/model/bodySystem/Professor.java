package com.bodyHealth.managerSystem.model.bodySystem;

import jakarta.persistence.*;

@Entity
@Table(name = "professor")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String categoria;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Professor(){

    }
    public Professor(String nome, String categoria) {
        this.nome = nome;
        this.categoria = categoria;
    }
    public Professor(DadosProfessor dados) {
        this.nome = dados.nome();
        this.categoria = dados.categoria();
    }

    public void AtualizarProfessor(DadosAlterarProfessor dados) {
        this.nome = dados.nome();
        this.categoria = dados.categoria();
    }

}

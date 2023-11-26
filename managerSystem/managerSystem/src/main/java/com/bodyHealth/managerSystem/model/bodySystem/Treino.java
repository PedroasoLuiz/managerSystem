package com.bodyHealth.managerSystem.model.bodySystem;

import jakarta.persistence.*;

import java.sql.Time;
import java.time.LocalTime;

@Entity
@Table(name="treino")
public class Treino {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRepeticao() {
        return repeticao;
    }

    public void setRepeticao(int repeticao) {
        this.repeticao = repeticao;
    }

    public LocalTime getTempo() {
        return tempo;
    }

    public void setTempo(LocalTime tempo) {
        this.tempo = tempo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int repeticao;
    private LocalTime tempo;
    private String nome;


    public Treino(DadosTreino dados) {
        this.tempo = dados.tempo();
        this.repeticao = dados.repeticao();
        this.nome = dados.nome();
    }

    public void AtualizarTreino(DadosAlterarTreino dados) {
        this.tempo = dados.tempo();
        this.repeticao = dados.repeticao();
        this.nome = dados.nome();
    }
    public Treino() {
    }

    public Treino(LocalTime tempo,int repeticao,String nome) {
        this.tempo = tempo;
        this.repeticao = repeticao;
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}

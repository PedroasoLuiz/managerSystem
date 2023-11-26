package com.bodyHealth.managerSystem.model.bodySystem;

import jakarta.persistence.*;
@Entity
@Table(name="ficha")
public class Ficha {

    public Long getId() {
        return id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Aluno getAluno() {
        return aluno;
    }

    public Professor getProfessor() {
        return professor;
    }

    public Treino getTreino() {
        return treino;
    }

    @ManyToOne
    @JoinColumn(name = "idAluno")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "idProf")
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "idTreino")
    private Treino treino;

    public Ficha(DadosFicha dados) {
        this.aluno = dados.aluno();
        this.professor = dados.professor();
        this.treino = dados.treino();
    }

    public void AtualizarFicha(DadosAlterarFicha dados) {
        this.aluno = dados.aluno();
        this.professor = dados.professor();
        this.treino = dados.treino();
    }
}

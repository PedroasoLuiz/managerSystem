package com.bodyHealth.managerSystem.model.bodySystem;

import jakarta.persistence.*;

@Entity
@Table(name="treinos")
public class Treino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public int repeticao;

    public Treino(){}

}

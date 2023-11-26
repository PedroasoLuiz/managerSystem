package com.bodyHealth.managerSystem.model.bodySystem;

import java.sql.Time;
import java.time.LocalTime;

public record DadosAlterarTreino(Long id, LocalTime tempo, int repeticao, String nome) {
}

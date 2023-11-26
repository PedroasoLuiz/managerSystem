package com.bodyHealth.managerSystem.model.bodySystem;

import java.sql.Time;
import java.time.LocalTime;

public record DadosTreino(Long id, LocalTime tempo, int repeticao, String nome) {
}

package com.bodyHealth.managerSystem.model.bodySystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;
public interface FichaRepository extends JpaRepository<Ficha, Long> {

    @Query(value ="SELECT t.nome, t.tempo, t.repeticao FROM treino t INNER JOIN ficha f ON f.idTreino = t.id WHERE f.idAluno = :idAluno", nativeQuery = true)
    List<Treino> findByAluno(@Param("idAluno") long idAluno);
}

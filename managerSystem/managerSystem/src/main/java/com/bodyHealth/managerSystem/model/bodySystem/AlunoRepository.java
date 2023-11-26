package com.bodyHealth.managerSystem.model.bodySystem;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface AlunoRepository extends JpaRepository<Aluno,Long>{
    List<Aluno> findByNome(String nome);
    @Query("SELECT a FROM Aluno a")
    List<Aluno>findAll(Sort sort);
}

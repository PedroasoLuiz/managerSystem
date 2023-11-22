package com.bodyHealth.managerSystem.model.bodySystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface ProfessorRepository extends JpaRepository<Professor,Long>{

    @Query(value="SELECT * FROM professor ORDER BY id DESC",nativeQuery = true)
    List<Professor> getAll();

    List<Professor>findByCategoria(String categoria);
}

package com.bodyHealth.managerSystem.model.bodySystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface TreinoRepository extends JpaRepository<Treino,Long> {
    @Query(value="SELECT * FROM treino ORDER BY id DESC",nativeQuery = true)
    List<Treino> getAll();
    List<Treino>findByNome(String treino);

}

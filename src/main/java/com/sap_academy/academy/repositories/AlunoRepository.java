package com.sap_academy.academy.repositories;

import com.sap_academy.academy.model.AlunoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AlunoRepository extends JpaRepository<AlunoModel,Long> {
    Optional<AlunoModel> findById(Long id);

}

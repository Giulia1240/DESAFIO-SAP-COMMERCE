package com.sap_academy.academy.repositories;

import com.sap_academy.academy.model.CursoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<CursoModel,Long> {
}

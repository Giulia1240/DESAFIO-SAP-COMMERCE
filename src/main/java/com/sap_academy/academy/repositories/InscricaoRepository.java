package com.sap_academy.academy.repositories;

import com.sap_academy.academy.model.AlunoModel;
import com.sap_academy.academy.model.CursoModel;
import com.sap_academy.academy.model.InscricaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscricaoRepository extends JpaRepository<InscricaoModel,Long> {

}

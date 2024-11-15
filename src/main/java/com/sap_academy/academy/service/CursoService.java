package com.sap_academy.academy.service;

import com.sap_academy.academy.model.CursoModel;

import java.util.List;

public interface CursoService {
    public CursoModel save(CursoModel cursoModel);
    List<CursoModel> findAll();

    public CursoModel findById(Long id) ;
}

package com.sap_academy.academy.service;

import com.sap_academy.academy.model.AlunoModel;
import java.util.List;


public interface AlunoService {

    public AlunoModel save(AlunoModel alunoModel);
    List<AlunoModel> findAll();

    public AlunoModel findById(Long id) ;

}

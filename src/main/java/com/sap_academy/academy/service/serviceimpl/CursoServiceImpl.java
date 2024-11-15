package com.sap_academy.academy.service.serviceimpl;


import com.sap_academy.academy.model.AlunoModel;
import com.sap_academy.academy.model.CursoModel;
import com.sap_academy.academy.repositories.CursoRepository;
import com.sap_academy.academy.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {


    @Autowired
    CursoRepository cursoRepository;
    @Override
    public CursoModel save(CursoModel cursoModel) {
        return cursoRepository.save(cursoModel);
    }

    @Override
    public List<CursoModel> findAll() {
        return cursoRepository.findAll();
    }

    @Override
    public CursoModel findById(Long id) {
        Optional<CursoModel> obj = cursoRepository.findById(id);
        return obj.get();
    }
}

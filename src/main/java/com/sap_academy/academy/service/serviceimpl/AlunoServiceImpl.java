package com.sap_academy.academy.service.serviceimpl;

import com.sap_academy.academy.model.AlunoModel;
import com.sap_academy.academy.repositories.AlunoRepository;
import com.sap_academy.academy.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;
import java.util.Optional;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    @Override
    public AlunoModel save(AlunoModel aluno) {

        return alunoRepository.save(aluno);
    }

    @Override
    public List<AlunoModel> findAll() {
        return  alunoRepository.findAll();
    }

    @Override
    public AlunoModel findById(Long id) {{
            Optional<AlunoModel> obj = alunoRepository.findById(id);
            return obj.get();
        }
    }

}

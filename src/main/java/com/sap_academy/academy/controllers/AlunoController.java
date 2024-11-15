package com.sap_academy.academy.controllers;

import com.sap_academy.academy.dto.AlunoModelDTO;
import com.sap_academy.academy.model.AlunoModel;
import com.sap_academy.academy.service.serviceimpl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoController {

    @Autowired
    private AlunoServiceImpl alunoService;


    @PostMapping("/salvarAluno")
    public ResponseEntity<AlunoModelDTO> save(@RequestBody AlunoModelDTO alunoDTO) {
        AlunoModel aluno = new AlunoModel(alunoDTO);
        AlunoModel alunoSalvo = alunoService.save(aluno);
        AlunoModelDTO alunoModelDTO = new AlunoModelDTO(alunoSalvo);

        System.out.println("ID Gerado: " + alunoSalvo.getId());

        return ResponseEntity.status(HttpStatus.CREATED).body(alunoModelDTO);
    }



    @GetMapping
    public ResponseEntity<List<AlunoModelDTO>> findAll() {

        List<AlunoModel> listAll = alunoService.findAll();
        List<AlunoModelDTO> listDTO = new ArrayList<>();

        for (AlunoModel aluno : listAll) {
            listDTO.add(new AlunoModelDTO(aluno));
        }

        return ResponseEntity.ok(listDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoModelDTO> getAlunoById(@PathVariable Long id) {
        AlunoModel alunoMD = alunoService.findById(id);

        // Convertendo AlunoModel para AlunoModelDTO
        AlunoModelDTO alunoModelDTO = new AlunoModelDTO(alunoMD);

        return ResponseEntity.ok().body(alunoModelDTO);
    }
}

package com.sap_academy.academy.controllers;

import com.sap_academy.academy.dto.CursoModelDTO;
import com.sap_academy.academy.model.CursoModel;
import com.sap_academy.academy.service.serviceimpl.CursoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/cursos")
public class CursoController {
    @Autowired
    CursoServiceImpl cursoService;

    @PostMapping("/salvarCurso")
    public ResponseEntity<CursoModelDTO> save(@RequestBody CursoModelDTO cursoDTO) {
        CursoModel curso = new CursoModel(cursoDTO);
        CursoModel cursoSalvo = cursoService.save(curso);

        CursoModelDTO cursoModelDTO = new CursoModelDTO(cursoSalvo);

        System.out.println("ID Gerado: " + cursoSalvo.getId());

        return ResponseEntity.status(HttpStatus.CREATED).body(cursoModelDTO);
    }
    @GetMapping
    public ResponseEntity<List<CursoModelDTO>> findAll(){

        List<CursoModel> listAll = cursoService.findAll();
        List<CursoModelDTO> listCursoDTO = new ArrayList<>();

        for (CursoModel curso : listAll) {
            listCursoDTO.add(new CursoModelDTO(curso));
        }

        return ResponseEntity.ok(listCursoDTO);

    }
    @GetMapping("/{id}")
    public ResponseEntity<CursoModelDTO> getAlunoById(@PathVariable Long id) {
        CursoModel cursoMD = cursoService.findById(id);

        // Convertendo AlunoModel para AlunoModelDTO
        CursoModelDTO cursooModelDTO = new CursoModelDTO(cursoMD);

        return ResponseEntity.ok().body(cursooModelDTO);
    }
}

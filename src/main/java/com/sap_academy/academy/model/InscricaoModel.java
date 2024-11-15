package com.sap_academy.academy.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TBG_INSCRICAO")
public class InscricaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relacionamento com AlunoModel
    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private AlunoModel aluno;

    // Relacionamento com CursoModel
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private CursoModel curso;

    // Getters e setters
    public AlunoModel getAluno() {
        return aluno;
    }

    public void setAluno(AlunoModel aluno) {
        this.aluno = aluno;
    }

    public CursoModel getCurso() {
        return curso;
    }

    public void setCurso(CursoModel curso) {
        this.curso = curso;
    }
}


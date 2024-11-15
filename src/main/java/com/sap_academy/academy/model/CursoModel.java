package com.sap_academy.academy.model;


import com.sap_academy.academy.dto.AlunoModelDTO;
import com.sap_academy.academy.dto.CursoModelDTO;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="TBG_CURSO")
public class CursoModel implements Serializable {

    private static  final Long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 33)
    private String nome;
    @Column(length = 500)
    private String descricao;
    private LocalDate data_criacao = LocalDate.now();
    @ManyToMany
    @JoinTable(
            name = "TBG_CURSO_INSCRICAO",
            joinColumns = @JoinColumn(name = "curso_id"),
            inverseJoinColumns = @JoinColumn(name = "aluno_id")
    )
    private List<AlunoModel> inscricoes;


    public CursoModel() {}

    public CursoModel(CursoModelDTO cursoDTO) {
        this.nome = cursoDTO.getNome();
        this.descricao = cursoDTO.getDescricao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(LocalDate data_criacao) {
        this.data_criacao = data_criacao;
    }

    public List<AlunoModel> getInscricoes() {
        return inscricoes;
    }

    public void setInscricoes(List<AlunoModel> inscricoes) {
        this.inscricoes = inscricoes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CursoModel that = (CursoModel) o;
        return id == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "CursoModel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", data_criacao=" + data_criacao +
                '}';
    }
}

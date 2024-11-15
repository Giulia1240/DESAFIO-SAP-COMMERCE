package com.sap_academy.academy.model;

import com.sap_academy.academy.dto.AlunoModelDTO;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TBG_ALUNO")
public class AlunoModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 22)
    private String nome;

    @Column(length = 100)
    private String email;

    // Relacionamento muitos-para-muitos com CursoModel
    @ManyToMany
    @JoinTable(
            name = "TBG_ALUNO_INSCRICAO",
            joinColumns = @JoinColumn(name = "aluno_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private List<CursoModel> inscricao;  // Lista de cursos em que o aluno está inscrito

    private LocalDate datacadastro = LocalDate.now();

    // Construtores

    public AlunoModel() {
    }

    public AlunoModel(AlunoModelDTO alunoDTO) {
        this.nome = alunoDTO.getNome();
        this.email = alunoDTO.getEmail();
    }

    // Getters e Setters
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(LocalDate datacadastro) {
        this.datacadastro = datacadastro;
    }

    public List<CursoModel> getInscricao() {
        return inscricao;
    }

    public void setInscricao(List<CursoModel> inscricao) {
        this.inscricao = inscricao;
    }

    // Métodos equals e hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlunoModel that = (AlunoModel) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // Método toString
    @Override
    public String toString() {
        return "AlunoModel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", datacadastro=" + datacadastro +
                '}';
    }
}

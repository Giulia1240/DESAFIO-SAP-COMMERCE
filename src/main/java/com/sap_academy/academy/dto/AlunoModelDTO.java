package com.sap_academy.academy.dto;

import com.sap_academy.academy.model.AlunoModel;

import java.time.LocalDate;
import java.util.Objects;

public class AlunoModelDTO {

    private long id;
    private String nome;
    private String email;
    private LocalDate datacadastro = LocalDate.now();

    public AlunoModelDTO() {
    }

    public AlunoModelDTO(AlunoModel aluno) {
        this.nome = aluno.getNome();
        this.email = aluno.getEmail();
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDatacadastro() {
        return datacadastro;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDatacadastro(LocalDate datacadastro) {
        this.datacadastro = datacadastro;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AlunoModelDTO that = (AlunoModelDTO) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

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

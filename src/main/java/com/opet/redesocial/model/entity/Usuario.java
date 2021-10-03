package com.opet.redesocial.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "usuario", schema = "redesocial")
public class Usuario {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "senha")
    @JsonIgnore
    private String senha;

    @Column(name = "telefone")
    private Integer telefone;

    @Column(name = "email")
    private String email;

    public Usuario(String nome, String email, Integer telefone,String senha ) {
        this.nome = nome;
        this.senha = senha;
        this.telefone = telefone;
        this.email = email;
    }

    public Usuario(String email, String senha){
        this.email = email;
        this.senha = senha;
    }
    public Usuario(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

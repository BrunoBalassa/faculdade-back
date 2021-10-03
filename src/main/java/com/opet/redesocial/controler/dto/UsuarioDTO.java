package com.opet.redesocial.controler.dto;

public class UsuarioDTO {
    private String nome;
    private String email;
    private Integer telefone;
    private String senha;


    public UsuarioDTO(String nome, String email,  Integer telefone, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
    }

    public UsuarioDTO(String email, String nome){
        this.email = email;
        this.senha = senha;
    }
    public UsuarioDTO(){}

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
}

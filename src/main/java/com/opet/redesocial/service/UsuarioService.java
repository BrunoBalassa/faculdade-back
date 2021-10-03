package com.opet.redesocial.service;

import com.opet.redesocial.model.entity.Usuario;

import java.util.Optional;

public interface UsuarioService {

    Usuario salvarUsuario(Usuario usuario);

    Usuario autenticar(String email, String senha) throws Exception;

    Optional<Usuario>obterUsuario(String email);



}

package com.opet.redesocial.service.UsuarioImp;

import com.opet.redesocial.model.entity.Usuario;
import com.opet.redesocial.model.repo.UsuarioRepo;
import com.opet.redesocial.service.UsuarioService;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class UsuarioImp implements UsuarioService {

    private UsuarioRepo usuarioRepo;

    public UsuarioImp(UsuarioRepo usuarioRepo){
        this.usuarioRepo = usuarioRepo;
    }

    @Override
    @Transactional
    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepo.save(usuario);
    }


    @Override
    public Usuario autenticar(String email, String senha) throws Exception {
        Optional<Usuario> usuario = usuarioRepo.findByEmail(email);
        if (!usuario.isPresent()){
            throw new Exception("Usuario não encontrado.");
        }
        if(!usuario.get().getSenha().toString().equals(senha.toString())){
            throw new Exception("Senha inválida");
        }
        return usuario.get();
    }

    @Override
    public Optional<Usuario> obterUsuario(String email) {
       Optional<Usuario> usuario = usuarioRepo.findByEmail(email);
        return usuario;
    }
}

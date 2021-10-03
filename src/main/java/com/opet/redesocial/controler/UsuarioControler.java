package com.opet.redesocial.controler;

import com.opet.redesocial.controler.dto.UsuarioDTO;
import com.opet.redesocial.model.entity.Usuario;
import com.opet.redesocial.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/usuarios")
public class UsuarioControler {
    private UsuarioService usuarioService;

    public UsuarioControler(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody UsuarioDTO objDTO) {
        Usuario usuario = new Usuario(objDTO.getNome(), objDTO.getEmail(), objDTO.getTelefone(), objDTO.getSenha());
        try {
            Usuario salvar = usuarioService.salvarUsuario(usuario);
            return new ResponseEntity(salvar, HttpStatus.CREATED);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/autenticar")
    public ResponseEntity autenticar(@RequestBody UsuarioDTO usuarioDTO) {

        try {
            Usuario autenticado = usuarioService.autenticar(usuarioDTO.getEmail(), usuarioDTO.getSenha());
            return ResponseEntity.ok(autenticado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/buscar")
    public ResponseEntity buscarUsuario(@PathVariable("email") String email){
        Optional<Usuario> usuario = usuarioService.obterUsuario(email);
        return ResponseEntity.ok(usuario);
    }
}

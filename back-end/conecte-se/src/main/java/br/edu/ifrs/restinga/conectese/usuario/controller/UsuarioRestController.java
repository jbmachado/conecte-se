package br.edu.ifrs.restinga.conectese.usuario.controller;

import br.edu.ifrs.restinga.conectese.usuario.model.Usuario;
import br.edu.ifrs.restinga.conectese.usuario.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/usuario")
public class UsuarioRestController {
    
    private final UsuarioService service;
    
    @PostMapping(value = "/salvar")
    public Usuario salvarUsuario(
        @RequestBody
        @Validated
        Usuario usuario) {
        return service.salvarUsuario(usuario);
    }
}

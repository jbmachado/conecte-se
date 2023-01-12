package br.edu.ifrs.restinga.conectese.perfil.controller;

import java.util.List;

import br.edu.ifrs.restinga.conectese.perfil.model.Perfil;
import br.edu.ifrs.restinga.conectese.perfil.service.PerfilService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/perfil")
public class PerfilRestController {
    
    private final PerfilService perfilService;
    
    @PostMapping("/salvar")
    public Perfil createPerfil(
        @RequestBody @Validated
        Perfil perfil
    ){
        return perfilService.createPerfil(perfil);
    }
    
    @GetMapping("/buscarTodos")
    public List<Perfil> buscarTodos(){
        return perfilService.buscarTodos();
    }
}

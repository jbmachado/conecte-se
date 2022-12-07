package br.edu.ifrs.restinga.conectese.oportunidade.controller;

import java.util.List;

import br.edu.ifrs.restinga.conectese.oportunidade.model.Oportunidade;
import br.edu.ifrs.restinga.conectese.oportunidade.service.OportunidadeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/oportunidade")
public class OportunidadeRestController {
    
    private final OportunidadeService service;
    
    @PostMapping(value = "/salvar")
    public Oportunidade salvarOportunidade(
        @RequestBody
        @Validated
        Oportunidade oportunidade) {
        return service.salvarOportunidade(oportunidade);
    }
    
    @GetMapping(value = "/buscar")
    public List<Oportunidade> buscarTodos() {
        return service.buscarTodos();
    }
    
    @GetMapping(value = "/buscar/{id}")
    public ResponseEntity<Oportunidade> buscarPor(
        @PathVariable Integer id
    ) {
        return service.buscarPorId(id);
    }
}

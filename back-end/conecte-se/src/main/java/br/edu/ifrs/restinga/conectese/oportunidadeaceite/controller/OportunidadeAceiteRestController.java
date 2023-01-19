package br.edu.ifrs.restinga.conectese.oportunidadeaceite.controller;

import br.edu.ifrs.restinga.conectese.oportunidadeaceite.model.OportunidadeAceita;
import br.edu.ifrs.restinga.conectese.oportunidadeaceite.service.OportunidadeAceiteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/oportunidadeaceite")
public class OportunidadeAceiteRestController {
    
    private OportunidadeAceiteService service;
    
    @PostMapping(value = "/vincular")
    public ResponseEntity<?> vincularOportunidade(
        @RequestParam
        Integer idOportunidade,
        @RequestParam
        Integer idUsuario) {
        return service.vincularOportunidade(idOportunidade, idUsuario);
    }
}

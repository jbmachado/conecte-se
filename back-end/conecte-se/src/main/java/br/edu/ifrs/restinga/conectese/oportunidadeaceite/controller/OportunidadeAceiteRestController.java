package br.edu.ifrs.restinga.conectese.oportunidadeaceite.controller;

import br.edu.ifrs.restinga.conectese.oportunidadeaceite.model.OportunidadeAceita;
import br.edu.ifrs.restinga.conectese.oportunidadeaceite.service.OportunidadeAceiteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/oportunidadeaceite")
public class OportunidadeAceiteRestController {
    
    private OportunidadeAceiteService service;
    
    @PostMapping(value = "/vincular")
    public OportunidadeAceita vincularOportunidade(
        @PathVariable
        Integer idOportunidade,
        @PathVariable
        Integer idUsuario) {
        return service.vincularOportunidade(idOportunidade, idUsuario);
    }
}

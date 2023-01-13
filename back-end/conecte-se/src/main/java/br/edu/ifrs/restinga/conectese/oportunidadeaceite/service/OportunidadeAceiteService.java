package br.edu.ifrs.restinga.conectese.oportunidadeaceite.service;

import java.time.LocalDateTime;

import br.edu.ifrs.restinga.conectese.oportunidade.service.OportunidadeService;
import br.edu.ifrs.restinga.conectese.oportunidadeaceite.model.OportunidadeAceita;
import br.edu.ifrs.restinga.conectese.oportunidadeaceite.repository.OportunidadeAceiteRepository;
import br.edu.ifrs.restinga.conectese.perfil.model.Perfil;
import br.edu.ifrs.restinga.conectese.usuario.model.Usuario;
import br.edu.ifrs.restinga.conectese.usuario.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OportunidadeAceiteService {
    
    private final OportunidadeAceiteRepository oportunidadeAceiteRepository;
    private final OportunidadeService oportunidadeService;
    private final UsuarioService usuarioService;
    
    public ResponseEntity<OportunidadeAceita> vincularOportunidade(Integer idOportunidade, Integer idUsuario) {
        var oportunidade = oportunidadeService.buscarPorId(idOportunidade).getBody();
        var usuario = (Usuario) usuarioService.buscarPorId(idUsuario).getBody();
        
        OportunidadeAceita oportunidadeAceita = new OportunidadeAceita();
        oportunidadeAceita.setOportunidade(oportunidade);
        oportunidadeAceita.setUsuario(usuario);
        oportunidadeAceita.setDataAceite(LocalDateTime.now());

        return new ResponseEntity<OportunidadeAceita>(oportunidadeAceita, HttpStatus.CREATED);
    }
}

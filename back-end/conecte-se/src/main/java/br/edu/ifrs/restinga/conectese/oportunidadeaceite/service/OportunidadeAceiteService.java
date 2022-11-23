package br.edu.ifrs.restinga.conectese.oportunidadeaceite.service;

import java.time.LocalDateTime;

import br.edu.ifrs.restinga.conectese.oportunidade.model.Oportunidade;
import br.edu.ifrs.restinga.conectese.oportunidade.service.OportunidadeService;
import br.edu.ifrs.restinga.conectese.oportunidadeaceite.model.OportunidadeAceita;
import br.edu.ifrs.restinga.conectese.oportunidadeaceite.model.OportunidadeAceiteRepository;
import br.edu.ifrs.restinga.conectese.usuario.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OportunidadeAceiteService {
    
    private final OportunidadeAceiteRepository oportunidadeAceiteRepository;
    private final OportunidadeService oportunidadeService;
    private final UsuarioService usuarioService;
    
    public OportunidadeAceita vincularOportunidade(Integer idOportunidade, Integer idUsuario) {
        var oportunidade = oportunidadeService.buscarPorId(idOportunidade).getBody();
        var usuario = usuarioService.buscarPorId(idUsuario).getBody();
        
        OportunidadeAceita oportunidadeAceita = new OportunidadeAceita();
        oportunidadeAceita.setOportunidade(oportunidade);
        oportunidadeAceita.setUsuario(usuario);
        oportunidadeAceita.setDataAceite(LocalDateTime.now());
    
        return oportunidadeAceiteRepository.save(oportunidadeAceita);
    }
}

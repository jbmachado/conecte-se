package br.edu.ifrs.restinga.conectese.oportunidade.service;

import java.util.List;

import br.edu.ifrs.restinga.conectese.oportunidade.model.Oportunidade;
import br.edu.ifrs.restinga.conectese.usuario.model.Usuario;
import br.edu.ifrs.restinga.conectese.usuario.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OportunidadeService {
    
    private final OportunidadeRepository oportunidadeRepository;
    private final UsuarioService usuarioService;
    
    public ResponseEntity<?> salvarOportunidade(Oportunidade oportunidade) {
        var usuarioResponseEntity = usuarioService.buscarPorId(oportunidade.getCriador().getId());

        if(usuarioResponseEntity.getStatusCode() == HttpStatus.NOT_FOUND){
            return usuarioResponseEntity;
        }

        var usuario = (Usuario) usuarioResponseEntity.getBody();
        oportunidade.setCriador(usuario);

        return new ResponseEntity<Oportunidade>(oportunidadeRepository.save(oportunidade), HttpStatus.CREATED);
    }
    
    public ResponseEntity<List<Oportunidade>> buscarTodos() {
        return ResponseEntity.ok(oportunidadeRepository.findAll());
    }
    
    public ResponseEntity<?> buscarPorId(Integer id) {
        var oportunidade = oportunidadeRepository.findById(id);
    
        if (oportunidade.isPresent()) {
            return new ResponseEntity<Oportunidade>(oportunidade.get(), HttpStatus.OK);
        }
        return new ResponseEntity<String>("O portunidade id" + oportunidade.get().getId() + " nao existe", HttpStatus.NOT_FOUND);
    }
}

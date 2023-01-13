package br.edu.ifrs.restinga.conectese.perfil.service;

import java.util.List;

import br.edu.ifrs.restinga.conectese.perfil.model.Perfil;
import br.edu.ifrs.restinga.conectese.perfil.repository.PerfilRepository;
import br.edu.ifrs.restinga.conectese.usuario.model.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PerfilService {
    
    private final PerfilRepository perfilRepository;
    
    public ResponseEntity<Perfil> createPerfil(Perfil perfil) {
        return new ResponseEntity<Perfil>(perfilRepository.save(perfil), HttpStatus.CREATED);
    }
    
    public ResponseEntity<?> buscarPorNome(String nome) {
        var perfil = perfilRepository.findByNome(nome);
        
        if (perfil.isPresent()) {
            return new ResponseEntity<Perfil>(perfil.get(), HttpStatus.OK);
        }
        return new ResponseEntity<String>("Perfil não encontrado", HttpStatus.NOT_FOUND);
    }
    
    public ResponseEntity<?> buscarPorId(Integer id) {
        var perfil = perfilRepository.findById(id);
        
        if (perfil.isPresent()) {
            return new ResponseEntity<Perfil>(perfil.get(), HttpStatus.OK);
        }
        return new ResponseEntity<String>("Perfil não encontrado", HttpStatus.NOT_FOUND);
    }
    
    public ResponseEntity<List<Perfil>> buscarTodos() {
        return ResponseEntity.ok(perfilRepository.findAll());
    }
}

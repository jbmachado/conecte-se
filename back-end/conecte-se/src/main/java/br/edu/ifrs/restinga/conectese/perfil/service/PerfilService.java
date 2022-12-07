package br.edu.ifrs.restinga.conectese.perfil.service;

import java.util.List;

import br.edu.ifrs.restinga.conectese.perfil.model.Perfil;
import br.edu.ifrs.restinga.conectese.perfil.repository.PerfilRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PerfilService {
    
    private final PerfilRepository perfilRepository;
    
    public Perfil createPerfil(Perfil perfil) {
        return perfilRepository.save(perfil);
    }
    
    public ResponseEntity<Perfil> buscarPorNome(String nome) {
        var perfil = perfilRepository.findByName(nome);
        
        if (perfil.isPresent()) {
            return ResponseEntity.ok(perfil.get());
        }
        return ResponseEntity.notFound().build();
    }
    
    public ResponseEntity<Perfil> buscarPorId(Integer id) {
        var perfil = perfilRepository.findById(id);
        
        if (perfil.isPresent()) {
            return ResponseEntity.ok(perfil.get());
        }
        return ResponseEntity.notFound().build();
    }
    
    public List<Perfil> buscarTodos() {
        return perfilRepository.findAll();
    }
}

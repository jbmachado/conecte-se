package br.edu.ifrs.restinga.conectese.oportunidade.service;

import java.util.List;

import br.edu.ifrs.restinga.conectese.oportunidade.model.Oportunidade;
import br.edu.ifrs.restinga.conectese.perfil.model.Perfil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OportunidadeService {
    
    private final OportunidadeRepository oportunidadeRepository;
    
    public ResponseEntity<Oportunidade> salvarOportunidade(Oportunidade oportunidade) {
        return new ResponseEntity<Oportunidade>(oportunidadeRepository.save(oportunidade), HttpStatus.CREATED);
    }
    
    public ResponseEntity<List<Oportunidade>> buscarTodos() {
        return ResponseEntity.ok(oportunidadeRepository.findAll());
    }
    
    public ResponseEntity<?> buscarPorId(Integer id) {
        var oportunidade = oportunidadeRepository.findById(id);
    
        if (oportunidade.isPresent()) {
            return ResponseEntity.ok(oportunidade.get());
        }
        return new ResponseEntity<String>("Oportunidade não encontrada", HttpStatus.NOT_FOUND);
    }
}

package br.edu.ifrs.restinga.conectese.oportunidade.service;

import java.util.List;
import java.time.LocalDateTime;

import br.edu.ifrs.restinga.conectese.oportunidade.model.Oportunidade;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OportunidadeService {
    
    private final OportunidadeRepository oportunidadeRepository;
    
    public Oportunidade salvarOportunidade(Oportunidade oportunidade) {
        // oportunidade.setDataCriacao(LocalDateTime.now());
        return oportunidadeRepository.save(oportunidade);
    }
    
    public List<Oportunidade> buscarTodos() {
        return oportunidadeRepository.findAll();
    }
    
    public ResponseEntity<Oportunidade> buscarPorId(Integer id) {
        var oportunidade = oportunidadeRepository.findById(id);
    
        if (oportunidade.isPresent()) {
            return ResponseEntity.ok(oportunidade.get());
        }
        return ResponseEntity.notFound().build();
    }
}

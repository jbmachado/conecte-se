package br.edu.ifrs.restinga.conectese.oportunidade.service;

import br.edu.ifrs.restinga.conectese.oportunidade.model.Oportunidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OportunidadeRepository extends JpaRepository<Oportunidade, Integer> {
}

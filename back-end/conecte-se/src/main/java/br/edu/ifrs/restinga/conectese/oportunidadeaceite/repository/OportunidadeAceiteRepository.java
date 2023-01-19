package br.edu.ifrs.restinga.conectese.oportunidadeaceite.repository;

import br.edu.ifrs.restinga.conectese.oportunidadeaceite.model.OportunidadeAceita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OportunidadeAceiteRepository extends JpaRepository<OportunidadeAceita, Integer> {
}

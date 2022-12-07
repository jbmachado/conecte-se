package br.edu.ifrs.restinga.conectese.perfil.repository;

import java.util.Optional;

import br.edu.ifrs.restinga.conectese.perfil.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Integer> {
    Optional<Perfil> findByNome(String nomeid);
}

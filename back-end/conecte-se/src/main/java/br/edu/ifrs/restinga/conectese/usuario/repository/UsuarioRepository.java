package br.edu.ifrs.restinga.conectese.usuario.repository;

import java.util.Optional;

import br.edu.ifrs.restinga.conectese.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByMail(String mail);
}

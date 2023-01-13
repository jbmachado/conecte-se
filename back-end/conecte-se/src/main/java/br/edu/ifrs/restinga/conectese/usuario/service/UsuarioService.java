package br.edu.ifrs.restinga.conectese.usuario.service;

import br.edu.ifrs.restinga.conectese.perfil.model.Perfil;
import br.edu.ifrs.restinga.conectese.perfil.service.PerfilService;
import br.edu.ifrs.restinga.conectese.usuario.model.Usuario;
import br.edu.ifrs.restinga.conectese.usuario.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PerfilService perfilService;

    public ResponseEntity<?> salvarUsuario(Usuario usuario) {
        usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getPassword()));
        var perfilResponseEntity = perfilService.buscarPorNome("usuario");
        if (perfilResponseEntity.getStatusCode() != HttpStatus.NOT_FOUND) {
            var perfil = (Perfil) perfilResponseEntity.getBody();
            usuario.setPerfils(List.of(perfil));
        }
        if (!usuarioRepository.findByNameNotExist(usuario.getMail())) {
//            usuario.setDataCriacao(LocalDateTime.now());
            return new ResponseEntity<Usuario>(usuario, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<String>("Email: " + usuario.getMail() +
                                                    " já Cadastrado", HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<?> buscarPorId(Integer id) {
        var usuario = usuarioRepository.findById(id);

        if (usuario.isPresent()) {
            return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
        }
        return new ResponseEntity<String>("Usuario não Encontrado. ", HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> alterarPerfil(Integer idUsuario, Integer idPerfil) {
        var usuarioResponseEntity = buscarPorId(idUsuario);
        var perfilResponseEntity = perfilService.buscarPorId(idPerfil);

        if (usuarioResponseEntity.getStatusCode() == HttpStatus.NOT_FOUND) {
            return usuarioResponseEntity;
        }

        if (perfilResponseEntity.getStatusCode() == HttpStatus.NOT_FOUND) {
            return perfilResponseEntity;
        }

        var usuario = (Usuario) usuarioResponseEntity.getBody();
        var perfil = (Perfil) perfilResponseEntity.getBody();

        usuario.setPerfils(List.of(perfil));

        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }
}

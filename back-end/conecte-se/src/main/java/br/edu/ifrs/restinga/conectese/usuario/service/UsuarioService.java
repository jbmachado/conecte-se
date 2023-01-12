package br.edu.ifrs.restinga.conectese.usuario.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import br.edu.ifrs.restinga.conectese.perfil.service.PerfilService;
import br.edu.ifrs.restinga.conectese.usuario.model.Usuario;
import br.edu.ifrs.restinga.conectese.usuario.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioService {
    
    private final UsuarioRepository usuarioRepository;
    private final PerfilService perfilService;
    
    public ResponseEntity<Usuario> salvarUsuario(Usuario usuario) {
        usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getPassword()));
        var perfil = perfilService.buscarPorNome("usuario");
        if (!Objects.isNull(perfil.getBody())) {
            usuario.setPerfils(List.of(perfil.getBody()));
        }
        if (!usuarioRepository.findByNameNotExist(usuario.getMail())) {
            usuario.setDataCriacao(LocalDateTime.now());
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
        }
        else {
            usuario.setMail("");
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

    }
    
    public ResponseEntity<Usuario> buscarPorId(Integer id) {
        var usuario = usuarioRepository.findById(id);
        
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        }
        return ResponseEntity.notFound().build();
    }
    
    public ResponseEntity<Usuario> alterarPerfil(Integer idUsuario, Integer idPerfil) {
        var usuario = buscarPorId(idUsuario).getBody();
        var perfil = perfilService.buscarPorId(idPerfil).getBody();
        
        if (Objects.isNull(usuario)) {
            return ResponseEntity.notFound().build();
        }
        
        if (Objects.isNull(perfil)) {
            return ResponseEntity.notFound().build();
        }
        
        usuario.setPerfils(List.of(perfil));
        return ResponseEntity.ok(usuario);
    }
}

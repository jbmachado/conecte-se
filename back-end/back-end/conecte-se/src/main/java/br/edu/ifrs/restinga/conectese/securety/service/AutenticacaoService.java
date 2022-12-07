package br.edu.ifrs.restinga.conectese.securety.service;

import java.util.Optional;

import br.edu.ifrs.restinga.conectese.usuario.model.Usuario;
import br.edu.ifrs.restinga.conectese.usuario.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AutenticacaoService implements UserDetailsService {
    
    private UsuarioRepository usuarioRepository;
    
    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        Optional<Usuario> admin = usuarioRepository.findByMail(mail);
        if (admin.isPresent())
            return admin.get();
        throw new UsernameNotFoundException("Dados Invalidos");
    }
}

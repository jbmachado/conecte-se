package br.edu.ifrs.restinga.conectese.securety.service;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifrs.restinga.conectese.usuario.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

@AllArgsConstructor
public class AutenticacaoTokenFilter extends OncePerRequestFilter {
    
    private final TokenService tokenService;
    private final UsuarioRepository usuarioRepository;
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {
        String token = recuperarToken(request);
        boolean valido = tokenService.isTokenValido(token);
        if(valido){
            autenticarUsuario(token);
        }
        
        filterChain.doFilter(request, response);
    }
    
    private void autenticarUsuario(String token) {
        // var id = tokenService.getIdAdmin(token);
        // var usuario = usuarioRepository.findById(id);
        // UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(usuario,null,usuario.get().getPerfils());
        // SecurityContextHolder.getContext().setAuthentication(user);
    }
    
    private String recuperarToken(HttpServletRequest request) {
        var token = request.getHeader("Authorization");
        if (token == null || token.isEmpty() || !token.startsWith("Bearer "))
            return null;
        return token.substring(7);
    }
}

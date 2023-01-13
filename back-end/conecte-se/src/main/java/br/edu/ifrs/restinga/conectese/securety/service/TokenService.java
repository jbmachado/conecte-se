package br.edu.ifrs.restinga.conectese.securety.service;

import java.util.Date;

import br.edu.ifrs.restinga.conectese.usuario.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TokenService {

    public String gerarToken(Authentication authentication) {
        var data = new Date();
        var dataFinal = new Date(data.getTime() + Long.parseLong("5000000000000"));
        var usuarioLogado = (Usuario) authentication.getPrincipal();
        System.out.println("Testando");
        System.out.println(usuarioLogado);
        return Jwts.builder().setIssuer("conecte-se")
            .claim("user", usuarioLogado)
            .setIssuedAt(data)
            .setExpiration(dataFinal)
            .signWith(SignatureAlgorithm.HS256, "testando")
            .compact();
    }

    public boolean isTokenValido(String token) {
        try {
            Jwts.parser().setSigningKey("testando").parseClaimsJws(token);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public Integer getIdAdmin(String token) {
        Claims claims = Jwts.parser().setSigningKey("testando").parseClaimsJws(token).getBody();
        return Integer.parseInt(claims.getSubject());
    }
}

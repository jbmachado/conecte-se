package br.edu.ifrs.restinga.conectese.securety.service;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

import br.edu.ifrs.restinga.conectese.auth.model.TokenRequest;
import br.edu.ifrs.restinga.conectese.usuario.model.Usuario;
import com.google.gson.*;
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


        return Jwts.builder().setIssuer("conecte-se")
            .setSubject(usuarioLogado.getId().toString())
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
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (json, type, jsonDeserializationContext) ->
                ZonedDateTime.parse(json.getAsJsonPrimitive().getAsString()).toLocalDateTime()).create();
        var jsonClaims = gson.toJson(claims);
        var tokenRequest = gson.fromJson(jsonClaims, TokenRequest.class);
        System.out.println(tokenRequest);
        return tokenRequest.getUser().getId();
    }
}

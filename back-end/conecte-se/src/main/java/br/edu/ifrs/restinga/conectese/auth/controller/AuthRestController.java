package br.edu.ifrs.restinga.conectese.auth.controller;

import br.edu.ifrs.restinga.conectese.auth.model.Login;
import br.edu.ifrs.restinga.conectese.auth.model.Token;
import br.edu.ifrs.restinga.conectese.securety.service.TokenService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/auth")
public class AuthRestController {
    
    private final AuthenticationManager authenticationManager;
    
    private final TokenService tokenService;
    
    @PostMapping
    public ResponseEntity<Token> autenticacao(
        @RequestBody
        @Validated
        Login login) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
            new UsernamePasswordAuthenticationToken(login.getLogin(), login.getSenha());
        try {
            var authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
            var token = tokenService.gerarToken(authentication);
            return ResponseEntity.ok(new Token(token, "Bearer"));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
        
    }
}

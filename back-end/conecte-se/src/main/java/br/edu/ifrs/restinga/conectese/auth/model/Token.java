package br.edu.ifrs.restinga.conectese.auth.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Token {
    
    private String token;
    private String tipo;

}

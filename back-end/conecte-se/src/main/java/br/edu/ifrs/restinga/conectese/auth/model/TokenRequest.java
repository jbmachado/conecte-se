package br.edu.ifrs.restinga.conectese.auth.model;

import br.edu.ifrs.restinga.conectese.usuario.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenRequest {

    private String iss;
    private Usuario user;

}

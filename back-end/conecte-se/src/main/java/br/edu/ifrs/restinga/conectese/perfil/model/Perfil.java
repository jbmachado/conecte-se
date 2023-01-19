package br.edu.ifrs.restinga.conectese.perfil.model;


import javax.persistence.*;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Data
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Perfil implements GrantedAuthority {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull
    private String nome;
    
    @Override
    public String getAuthority() {
        return this.nome;
    }
}

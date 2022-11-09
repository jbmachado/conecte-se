package br.edu.ifrs.restinga.conectese.perfil;


import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String id;
    private String nome;
    
    @Override
    public String getAuthority() {
        return this.nome;
    }
}

package br.edu.ifrs.restinga.conectese.usuario.model;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import javax.persistence.*;

import br.edu.ifrs.restinga.conectese.oportunidadeaceite.model.OportunidadeAceita;
import br.edu.ifrs.restinga.conectese.perfil.model.Perfil;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements UserDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String mail;
    private String senha;
    private String avatar;
    private String nome;
    private String sobrenome;
    private LocalDateTime dataCriacao;
    private String telefone;
    private Boolean status;
    
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<OportunidadeAceita> oportunidadeAceitas;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Perfil> perfils;
    
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return perfils;
    }
    
    @Override
    public String getPassword() {
        return senha;
    }
    
    @Override
    public String getUsername() {
        return mail;
    }
    
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    
    @Override
    public boolean isEnabled() {
        return true;
    }
}

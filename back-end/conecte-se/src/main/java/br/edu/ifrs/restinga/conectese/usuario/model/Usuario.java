package br.edu.ifrs.restinga.conectese.usuario.model;

import br.edu.ifrs.restinga.conectese.oportunidadeaceite.model.OportunidadeAceita;
import br.edu.ifrs.restinga.conectese.perfil.model.Perfil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements UserDetails {
    @PostLoad
    private void postLoad() {
        oportunidadesAceitasIds = oportunidadeAceitas.stream().map((data) -> data.getOportunidade().getId()).collect(Collectors.toSet());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Transient
    private Set<Integer> oportunidadesAceitasIds;

    @Email
    private String mail;

    private String senha;
    private String avatar;
    private String nome;
    private String sobrenome;
    private String telefone;
    private Boolean status;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<OportunidadeAceita> oportunidadeAceitas;
    @ManyToMany
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

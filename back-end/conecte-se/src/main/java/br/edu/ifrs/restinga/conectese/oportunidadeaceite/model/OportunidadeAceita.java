package br.edu.ifrs.restinga.conectese.oportunidadeaceite.model;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.edu.ifrs.restinga.conectese.oportunidade.model.Oportunidade;
import br.edu.ifrs.restinga.conectese.usuario.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class OportunidadeAceita {
    
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)    
    private Long id;
    @JsonIgnore
    @Getter
    @Setter
    private LocalDateTime dataAceite;
    @JsonIgnore
    @Getter
    @Setter
    @ManyToOne
    private Usuario usuario;
    @JsonIgnore
    @Getter
    @Setter
    @ManyToOne
    private Oportunidade oportunidade;
}

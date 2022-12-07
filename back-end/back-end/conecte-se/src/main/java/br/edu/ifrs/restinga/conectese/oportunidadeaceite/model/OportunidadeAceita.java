package br.edu.ifrs.restinga.conectese.oportunidadeaceite.model;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;

import br.edu.ifrs.restinga.conectese.oportunidade.model.Oportunidade;
import br.edu.ifrs.restinga.conectese.usuario.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class OportunidadeAceita {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private LocalDateTime dataAceite;
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Oportunidade oportunidade;
}

package br.edu.ifrs.restinga.conectese.oportunidade.model;

import javax.persistence.*;

import br.edu.ifrs.restinga.conectese.usuario.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Imagem {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String Url;
    
    @ManyToOne
    private Oportunidade oportunidade;
}

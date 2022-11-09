package br.edu.ifrs.restinga.conectese.oportunidade.model;

import java.time.LocalDateTime;
import java.util.List;
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
public class Oportunidade {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    
    @OneToOne
    private Usuario criador;
    private String titulo;
    private String descricao;
    private LocalDateTime dataCriacao;
    private String endereco;
    private String telefone;
    private Double valor;
    
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Imagem> imagem;
    private LocalDateTime validade;
    private Integer categoria;
    
}

package br.edu.ifrs.restinga.conectese.oportunidade.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.*;

import br.edu.ifrs.restinga.conectese.oportunidadeaceite.model.OportunidadeAceita;
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
    @PostLoad
    private void postLoad() {
        usuarioAceitosIds = oportunidadeAceitas.stream().map((data) -> data.getUsuario().getId()).collect(Collectors.toSet());
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    
    @Transient
    private Set<Integer> usuarioAceitosIds;

    @OneToOne
    private Usuario criador;
    private String titulo;
    private String descricao;
    private LocalDateTime dataCriacao;
    private String endereco;
    private String telefone;
    private Double valor;
    @OneToMany(mappedBy = "oportunidade", cascade = CascadeType.ALL)
    private List<Imagem> imagem;
    private LocalDateTime validade;
    private Integer categoria;
    
    @OneToMany(mappedBy = "oportunidade", cascade = CascadeType.ALL)
    private  List<OportunidadeAceita> oportunidadeAceitas;
}

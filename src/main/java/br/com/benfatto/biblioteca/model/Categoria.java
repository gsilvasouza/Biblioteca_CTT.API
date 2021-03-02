package br.com.benfatto.biblioteca.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@Entity
@Table(name = "TB_CATEGORIA")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //Unique seta que aquela coluna deve ser unica
    @Column(name = "categoria", unique = true)
    private String categoria;

    @OneToMany(mappedBy = "categoria")
    public List<Livro> livros;
}

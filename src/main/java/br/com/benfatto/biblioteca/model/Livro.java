package br.com.benfatto.biblioteca.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@Entity
@Table(name="TB_LIVRO")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer id;

    @Column(name="titulo")
    private String titulo;

    @Column(name = "autor")
    private String autor;

    @ManyToOne
    @JoinColumn(name = "categoria")
    private Categoria categoria;

    @Column(name = "status")
    private Boolean status;
}

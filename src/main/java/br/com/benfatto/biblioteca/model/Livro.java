package br.com.benfatto.biblioteca.model;

import javax.persistence.*;

@Entity
@Table(name="TB_LIVRO")
public class Biblioteca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column()
}

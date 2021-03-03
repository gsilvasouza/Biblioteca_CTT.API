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
@Table(name = "TB_CLIENTE")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column("nome")
    private String nome;

    @Column("email")
    private String email;

    @Column("telefone")
    private String telefone;

    @Column(name = "CPF", unique = true)
    private String CPF;

}

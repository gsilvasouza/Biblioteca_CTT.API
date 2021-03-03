package br.com.benfatto.biblioteca.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class ClienteDTO {
    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private String CPF;
}

package br.com.benfatto.biblioteca.dto;

import br.com.benfatto.biblioteca.model.Cliente;
import br.com.benfatto.biblioteca.model.Livro;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class ServicosDTO {
    private Integer id;
    private Livro livro;
    private Cliente cliente;
}

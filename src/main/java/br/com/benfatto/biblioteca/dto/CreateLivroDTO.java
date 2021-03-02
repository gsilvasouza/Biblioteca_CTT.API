package br.com.benfatto.biblioteca.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class CreateLivroDTO {
    private String titulo;
    private String autor;
    private String categoria;
    @JsonProperty("disponibilidade")
    private Boolean status;
}

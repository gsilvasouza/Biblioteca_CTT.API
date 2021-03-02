package br.com.benfatto.biblioteca.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class ListCategoriaDTO {
    private List<CategoriaDTO> data;
    private Integer size;

    public ListCategoriaDTO(List<CategoriaDTO> data) {
        this.data = data;
        this.size = data.size();
    }
}

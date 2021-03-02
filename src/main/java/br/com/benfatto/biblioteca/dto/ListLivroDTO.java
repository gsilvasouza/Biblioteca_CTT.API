package br.com.benfatto.biblioteca.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class ListLivroDTO {
    private List<LivroDTO> data;
    private Integer tamanho;

    public ListLivroDTO(List<LivroDTO> data) {
        this.data = data;
        this.tamanho = data.size();
    }
}

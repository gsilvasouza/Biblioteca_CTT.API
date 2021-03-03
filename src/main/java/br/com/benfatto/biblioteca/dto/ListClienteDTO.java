package br.com.benfatto.biblioteca.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class ListClienteDTO {
    private List<ClienteDTO> data;
    private Integer tamanho;

    public ListClienteDTO(List<ClienteDTO> data) {
        this.data = data;
        this.tamanho = data.size();
    }
}

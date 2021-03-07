package br.com.benfatto.biblioteca.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class ListServicosDTO {
    private List<ServicosDTO> data;
    @JsonProperty("quantidade de emprestimos")
    private Integer tamanho;

    public ListServicosDTO(List<ServicosDTO> data) {
        this.data = data;
        this.tamanho = data.size();
    }
}

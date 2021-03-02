package br.com.benfatto.biblioteca.mapper;

import br.com.benfatto.biblioteca.dto.CategoriaDTO;
import br.com.benfatto.biblioteca.dto.CreateCategoriaDTO;
import br.com.benfatto.biblioteca.model.Categoria;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {

    public Categoria mapToEntity(CreateCategoriaDTO dto){
        Categoria categoria = new Categoria();
        categoria.setCategoria(dto.getCategoria());
        return categoria;
    }

    public CategoriaDTO mapToDTO(Categoria entity){
        CategoriaDTO dto = new CategoriaDTO();
        dto.setId(entity.getId());
        dto.setCategoria(entity.getCategoria());
        return dto;
    }
}

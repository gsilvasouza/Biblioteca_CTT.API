package br.com.benfatto.biblioteca.mapper;

import br.com.benfatto.biblioteca.dto.CreateLivroDTO;
import br.com.benfatto.biblioteca.dto.LivroDTO;
import br.com.benfatto.biblioteca.model.Livro;
import br.com.benfatto.biblioteca.service.CategoriaService;
import org.springframework.stereotype.Component;

@Component
public class LivroMapper {
    private final CategoriaService categoriaService;

    public LivroMapper(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    public Livro mapToEntity(CreateLivroDTO dto){
        Livro entity = new Livro();
        entity.setAutor(dto.getAutor());
        if(dto.getCategoria() != null){
            entity.setCategoria(this.categoriaService
            .findByCategoria(dto.getCategoria()));
        }
        entity.setStatus(dto.getStatus());
        entity.setTitulo(dto.getTitulo());
        return entity;
    }

    public LivroDTO mapToDTO(Livro entity){
        LivroDTO dto = new LivroDTO();
        dto.setAutor(entity.getAutor());
        dto.setCategoria(entity.getCategoria().getCategoria());
        dto.setStatus(entity.getStatus());
        dto.setTitulo(entity.getTitulo());
        dto.setId(entity.getId());
        return dto;
    }
}

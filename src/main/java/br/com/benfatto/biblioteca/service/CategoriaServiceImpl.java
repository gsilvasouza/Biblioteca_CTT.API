package br.com.benfatto.biblioteca.service;

import br.com.benfatto.biblioteca.model.Categoria;
import br.com.benfatto.biblioteca.repository.CategoriaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class CategoriaServiceImpl extends BaseServiceImpl<Categoria, Integer> implements CategoriaService {
    private final CategoriaRepository repository;

    public CategoriaServiceImpl(JpaRepository<Categoria, Integer> repository, CategoriaRepository repository1) {
        super(repository);
        this.repository = repository1;
    }


    @Override
    public Categoria findByCategoria(String categoria) {
        return this.repository.findByCategoria(categoria)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("Categoria %s não encontrado",categoria)));
    }
}

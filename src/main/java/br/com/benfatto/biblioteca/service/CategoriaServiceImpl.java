package br.com.benfatto.biblioteca.service;

import br.com.benfatto.biblioteca.model.Categoria;
import br.com.benfatto.biblioteca.repository.CategoriaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl extends BaseServiceImpl<Categoria, Integer> implements CategoriaService {

    public CategoriaServiceImpl(JpaRepository<Categoria, Integer> repository) {
        super(repository);
    }

}

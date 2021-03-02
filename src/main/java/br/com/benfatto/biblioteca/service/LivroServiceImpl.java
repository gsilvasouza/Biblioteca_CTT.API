package br.com.benfatto.biblioteca.service;

import br.com.benfatto.biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public class LivroServiceImpl extends BaseServiceImpl<Livro, Integer> implements LivroService {

    public LivroServiceImpl(JpaRepository<Livro, Integer> repository) {
        super(repository);
    }
}

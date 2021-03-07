package br.com.benfatto.biblioteca.service;

import br.com.benfatto.biblioteca.model.Categoria;
import br.com.benfatto.biblioteca.model.Livro;
import br.com.benfatto.biblioteca.repository.LivroRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class LivroServiceImpl extends BaseServiceImpl<Livro, Integer> implements LivroService {
    private final LivroRepository livroRepository;

    public LivroServiceImpl(JpaRepository<Livro, Integer> repository, LivroRepository livroRepository) {
        super(repository);
        this.livroRepository = livroRepository;
    }


    @Override
    public List<Livro> findAllByTitulo(String titulo) {
        return this.livroRepository.findAllByTitulo(titulo)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("Nenhum livro encontrado com o titulo %s", titulo)));
    }

    @Override
    public List<Livro> findAllByAutor(String autor) {
        return this.livroRepository.findAllByAutor(autor)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("Nenhum livro encontrado com o autor %s", autor)));
    }

    @Override
    public List<Livro> findAllByCategoria(Categoria categoria) {
        return this.livroRepository.findAllByCategoria(categoria)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("Nenhum livro encontrado com a categoria %s", categoria.getCategoria())));
    }

    @Override
    public Livro findByTitulo(String titulo) {
        return this.livroRepository.findByTitulo(titulo)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("Nenhum livro encontrado com o titulo %s", titulo)));
    }
}

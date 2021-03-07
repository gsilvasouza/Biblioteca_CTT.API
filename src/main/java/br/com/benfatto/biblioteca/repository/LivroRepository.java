package br.com.benfatto.biblioteca.repository;

import br.com.benfatto.biblioteca.model.Categoria;
import br.com.benfatto.biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {
    Optional<List<Livro>> findAllByTitulo(String titulo);
    Optional<List<Livro>> findAllByAutor(String autor);
    Optional<List<Livro>> findAllByCategoria(Categoria categoria);
    Optional<Livro> findByTitulo(String titulo);
}

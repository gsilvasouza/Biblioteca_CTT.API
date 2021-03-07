package br.com.benfatto.biblioteca.service;

import br.com.benfatto.biblioteca.model.Categoria;
import br.com.benfatto.biblioteca.model.Livro;

import java.util.List;

public interface LivroService extends BaseService<Livro, Integer> {
    List<Livro> findAllByTitulo(String titulo);
    List<Livro> findAllByAutor(String autor);
    List<Livro> findAllByCategoria(Categoria categoria);
    Livro findByTitulo(String titulo);
}

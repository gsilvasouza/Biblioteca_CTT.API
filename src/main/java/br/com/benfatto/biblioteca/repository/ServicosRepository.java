package br.com.benfatto.biblioteca.repository;

import br.com.benfatto.biblioteca.model.Servicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicosRepository extends JpaRepository<Servicos, Integer> {
}

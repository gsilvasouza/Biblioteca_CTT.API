package br.com.benfatto.biblioteca.repository;

import br.com.benfatto.biblioteca.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Optional<Cliente> findByCPF(String cpf);
}

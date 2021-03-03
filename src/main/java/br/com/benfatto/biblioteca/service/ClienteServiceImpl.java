package br.com.benfatto.biblioteca.service;

import br.com.benfatto.biblioteca.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl extends BaseServiceImpl<Cliente, Integer> implements ClienteService {

    public ClienteServiceImpl(JpaRepository<Cliente, Integer> repository) {
        super(repository);
    }

}


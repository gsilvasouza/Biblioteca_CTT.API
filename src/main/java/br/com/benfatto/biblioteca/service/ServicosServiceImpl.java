package br.com.benfatto.biblioteca.service;

import br.com.benfatto.biblioteca.model.Servicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ServicosServiceImpl extends BaseServiceImpl<Servicos, Integer> implements ServicosService {

    public ServicosServiceImpl(JpaRepository<Servicos, Integer> repository) {
        super(repository);
    }

}

package br.com.benfatto.biblioteca.service;

import br.com.benfatto.biblioteca.model.Cliente;
import br.com.benfatto.biblioteca.repository.ClienteRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class ClienteServiceImpl extends BaseServiceImpl<Cliente, Integer> implements ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(JpaRepository<Cliente, Integer> repository, ClienteRepository clienteRepository) {
        super(repository);
        this.clienteRepository = clienteRepository;
    }


    @Override
    public Cliente findByCpf(String cpf) {
        return this.clienteRepository.findByCPF(cpf)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("Não encontrado nenhum clinte com o CPF: %s", cpf)));
    }
}


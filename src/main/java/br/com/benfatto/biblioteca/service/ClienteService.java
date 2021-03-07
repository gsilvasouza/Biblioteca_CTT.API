package br.com.benfatto.biblioteca.service;

import br.com.benfatto.biblioteca.model.Cliente;

public interface ClienteService extends BaseService<Cliente, Integer> {
    Cliente findByCpf(String cpf);
}

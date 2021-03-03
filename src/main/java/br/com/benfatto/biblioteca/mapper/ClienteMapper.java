package br.com.benfatto.biblioteca.mapper;

import br.com.benfatto.biblioteca.dto.ClienteDTO;
import br.com.benfatto.biblioteca.dto.CreateClienteDTO;
import br.com.benfatto.biblioteca.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {
    public Cliente maptoEntity(CreateClienteDTO dto) {
        Cliente entity = new Cliente();
        entity.setCPF(dto.getCPF());
        entity.setEmail(dto.getEmail());
        entity.setNome(dto.getNome());
        entity.setTelefone(dto.getTelefone());
        return entity;
    }

    public ClienteDTO mapToDTO(Cliente entity){
        ClienteDTO dto = new ClienteDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setCPF(entity.getCPF());
        dto.setEmail(entity.getEmail());
        dto.setTelefone(entity.getTelefone());
        return dto;
    }
}

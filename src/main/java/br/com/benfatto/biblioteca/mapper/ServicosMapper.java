package br.com.benfatto.biblioteca.mapper;

import br.com.benfatto.biblioteca.dto.CreateServicosDTO;
import br.com.benfatto.biblioteca.dto.ServicosDTO;
import br.com.benfatto.biblioteca.model.Servicos;
import br.com.benfatto.biblioteca.service.ClienteService;
import br.com.benfatto.biblioteca.service.LivroService;
import org.springframework.stereotype.Component;

@Component
public class ServicosMapper {
    private final ClienteService clienteService;
    private final LivroService livroService;

    public ServicosMapper(ClienteService clienteService, LivroService livroService) {
        this.clienteService = clienteService;
        this.livroService = livroService;
    }

    public Servicos mapToEntity(CreateServicosDTO dto){
        Servicos entity = new Servicos();
        entity.setCliente(this.clienteService.findByCpf(dto.getCpf()));
        entity.setLivro(this.livroService.findById(dto.getCodigo()));
        return entity;
    }

    public ServicosDTO mapToDTO(Servicos entity){
        ServicosDTO dto = new ServicosDTO();
        dto.setCliente(entity.getCliente());
        dto.setLivro(entity.getLivro());
        return dto;
    }
}

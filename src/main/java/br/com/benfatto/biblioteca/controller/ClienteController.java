package br.com.benfatto.biblioteca.controller;

import br.com.benfatto.biblioteca.dto.ClienteDTO;
import br.com.benfatto.biblioteca.dto.CreateClienteDTO;
import br.com.benfatto.biblioteca.dto.ListClienteDTO;
import br.com.benfatto.biblioteca.mapper.ClienteMapper;
import br.com.benfatto.biblioteca.model.Cliente;
import br.com.benfatto.biblioteca.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    private final ClienteService clienteService;
    private final ClienteMapper clienteMapper;

    public ClienteController(ClienteService clienteService, ClienteMapper clienteMapper) {
        this.clienteService = clienteService;
        this.clienteMapper = clienteMapper;
    }

    @GetMapping
    public ResponseEntity<ListClienteDTO> findAll(){
        List<ClienteDTO> founds = this.clienteService.findAll()
                .stream()
                .map(this.clienteMapper::mapToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(new ListClienteDTO(founds), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> foundById(@PathVariable Integer id){
        ClienteDTO found = this.clienteMapper.mapToDTO(this.clienteService.findById(id));
        return new ResponseEntity<>(found, HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> create(@RequestBody CreateClienteDTO dto){
        Cliente createCliente = this.clienteService.create(this.clienteMapper.maptoEntity(dto));
        return new ResponseEntity<>(this.clienteMapper.mapToDTO(createCliente), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> update(@PathVariable Integer id, @RequestBody ClienteDTO dto){
        Cliente found = this.clienteService.findById(id);
        found.setNome(dto.getNome());
        found.setTelefone(dto.getTelefone());
        found.setCPF(dto.getCPF());
        found.setEmail(dto.getEmail());
        return new ResponseEntity<>(this.clienteMapper.mapToDTO(this.clienteService.update(found)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        Cliente found = this.clienteService.findById(id);
        this.clienteService.delete(found);
        return new ResponseEntity<>("Resource removed", HttpStatus.OK);
    }
}

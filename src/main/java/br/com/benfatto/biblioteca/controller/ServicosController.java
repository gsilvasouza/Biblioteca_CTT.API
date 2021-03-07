package br.com.benfatto.biblioteca.controller;

import br.com.benfatto.biblioteca.dto.CreateServicosDTO;
import br.com.benfatto.biblioteca.dto.ListServicosDTO;
import br.com.benfatto.biblioteca.dto.ServicosDTO;
import br.com.benfatto.biblioteca.mapper.ServicosMapper;
import br.com.benfatto.biblioteca.model.Cliente;
import br.com.benfatto.biblioteca.model.Livro;
import br.com.benfatto.biblioteca.model.Servicos;
import br.com.benfatto.biblioteca.service.ClienteService;
import br.com.benfatto.biblioteca.service.LivroService;
import br.com.benfatto.biblioteca.service.ServicosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/servicos")
public class ServicosController {
    private final ServicosService servicosService;
    private final ServicosMapper servicosMapper;
    private final LivroService livroService;
    private final ClienteService clienteService;

    public ServicosController(ServicosService servicosService, ServicosMapper servicosMapper, LivroService livroService, ClienteService clienteService) {
        this.servicosService = servicosService;
        this.servicosMapper = servicosMapper;
        this.livroService = livroService;
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<ServicosDTO> create(@RequestBody CreateServicosDTO dto){
        Servicos entity = new Servicos();
        entity.setCliente(this.clienteService.findByCpf(dto.getCpf()));
        entity.setLivro(this.livroService.findById(dto.getCodigo()));
        return new ResponseEntity<>(this.servicosMapper.mapToDTO(
                this.servicosService.create(entity)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ListServicosDTO> findAll(){
        List<ServicosDTO> founds = this.servicosService.findAll()
                                .stream()
                                .map(this.servicosMapper::mapToDTO)
                                .collect(Collectors.toList());
        return new ResponseEntity<>(new ListServicosDTO(founds), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicosDTO> findById(@PathVariable Integer id){
        Servicos found = this.servicosService.findById(id);
        return new ResponseEntity<>(this.servicosMapper.mapToDTO(found), HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicosDTO> update(@PathVariable Integer id, @RequestBody ServicosDTO dto){
        Servicos found = this.servicosService.findById(id);
        found.setLivro(dto.getLivro());
        found.setCliente(dto.getCliente());
        return new ResponseEntity<>(this.servicosMapper.mapToDTO(this.servicosService.update(found)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        Servicos found = this.servicosService.findById(id);
        this.servicosService.delete(found);
        return new ResponseEntity<>("Resource removed", HttpStatus.OK);
    }

}

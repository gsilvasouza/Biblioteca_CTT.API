package br.com.benfatto.biblioteca.controller;

import br.com.benfatto.biblioteca.dto.CategoriaDTO;
import br.com.benfatto.biblioteca.dto.CreateCategoriaDTO;
import br.com.benfatto.biblioteca.dto.ListCategoriaDTO;
import br.com.benfatto.biblioteca.mapper.CategoriaMapper;
import br.com.benfatto.biblioteca.model.Categoria;
import br.com.benfatto.biblioteca.service.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
    private final CategoriaService categoriaService;
    private final CategoriaMapper categoriaMapper;

    public CategoriaController(CategoriaService categoriaService, CategoriaMapper categoriaMapper) {
        this.categoriaService = categoriaService;
        this.categoriaMapper = categoriaMapper;
    }

    @GetMapping()
    public ResponseEntity<ListCategoriaDTO> findAll(){
        List<CategoriaDTO> founds = this.categoriaService.findAll()
                .stream()
                .map(this.categoriaMapper::mapToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(new ListCategoriaDTO(founds), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> findById(@PathVariable Integer id) {
        CategoriaDTO found = this.categoriaMapper.mapToDTO(
                this.categoriaService.findById(id));
        return new ResponseEntity<>(found, HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> create(@RequestBody CreateCategoriaDTO dto){
        Categoria createCategoria = this.categoriaService.create(
                this.categoriaMapper.mapToEntity(dto));
        return new ResponseEntity<>(this.categoriaMapper.mapToDTO(createCategoria),
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> update(@PathVariable Integer id,
                                               @RequestBody CreateCategoriaDTO dto){
        Categoria found = this.categoriaService.findById(id);
        found.setCategoria(dto.getCategoria());
        return new ResponseEntity<>(this.categoriaMapper.mapToDTO(
                this.categoriaService.update(found)), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        Categoria found = this.categoriaService.findById(id);
        this.categoriaService.delete(found);
        return new ResponseEntity<>("Resource removed", HttpStatus.OK);
    }
}

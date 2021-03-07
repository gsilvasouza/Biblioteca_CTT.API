package br.com.benfatto.biblioteca.controller;

import br.com.benfatto.biblioteca.dto.CreateLivroDTO;
import br.com.benfatto.biblioteca.dto.ListLivroDTO;
import br.com.benfatto.biblioteca.dto.LivroDTO;
import br.com.benfatto.biblioteca.mapper.LivroMapper;
import br.com.benfatto.biblioteca.model.Categoria;
import br.com.benfatto.biblioteca.model.Livro;
import br.com.benfatto.biblioteca.service.CategoriaService;
import br.com.benfatto.biblioteca.service.LivroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/livro")
public class LivroController {
    private final LivroService livroService;
    private final LivroMapper livroMapper;
    private final CategoriaService categoriaService;

    public LivroController(LivroService livroService, LivroMapper livroMapper, CategoriaService categoriaService) {
        this.livroService = livroService;
        this.livroMapper = livroMapper;
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<ListLivroDTO>  foundAll(){
        List<LivroDTO> founds = this.livroService.findAll()
                .stream()
                .map(this.livroMapper::mapToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(new ListLivroDTO(founds), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDTO> findById(@PathVariable Integer id){
        LivroDTO found = this.livroMapper.mapToDTO(
            this.livroService.findById(id));
        return new ResponseEntity<>(found, HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<LivroDTO> create(@RequestBody CreateLivroDTO dto){
        Livro createLivro = this.livroService.create(this.livroMapper.mapToEntity(dto));
        return new ResponseEntity<>(this.livroMapper.mapToDTO(createLivro), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroDTO> update(@PathVariable Integer id, @RequestBody CreateLivroDTO dto){
        Livro found = this.livroService.findById(id);
        if(dto.getCategoria() != null){
            found.setCategoria(this.categoriaService.findByCategoria(dto.getCategoria()));
        }
        found.setStatus(dto.getStatus());
        found.setAutor(dto.getAutor());
        found.setTitulo(dto.getTitulo());
        return new ResponseEntity<>(this.livroMapper.mapToDTO(this.livroService.update(found)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        Livro found = this.livroService.findById(id);
        this.livroService.delete(found);
        return new ResponseEntity<>("Resource removed", HttpStatus.OK);
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<ListLivroDTO>  foundAllByCategoria(@PathVariable String categoria){
        Categoria foundCategoria = this.categoriaService.findByCategoria(categoria);
        List<LivroDTO> founds = this.livroService.findAllByCategoria(foundCategoria)
                .stream()
                .map(this.livroMapper::mapToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(new ListLivroDTO(founds), HttpStatus.FOUND);
    }

    @GetMapping("/autor/{autor}")
    public ResponseEntity<ListLivroDTO>  foundAllByAutor(@PathVariable String autor){
        List<LivroDTO> founds = this.livroService.findAllByAutor(autor)
                .stream()
                .map(this.livroMapper::mapToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(new ListLivroDTO(founds), HttpStatus.FOUND);
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<ListLivroDTO>  foundAllByTitulo(@PathVariable String titulo){
        List<LivroDTO> founds = this.livroService.findAllByTitulo(titulo)
                .stream()
                .map(this.livroMapper::mapToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(new ListLivroDTO(founds), HttpStatus.FOUND);
    }
}

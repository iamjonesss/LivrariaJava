package database.biblioteca_java.controllers;

import database.biblioteca_java.domain.Livraria;
import database.biblioteca_java.domain.LivrariaRepository;
import database.biblioteca_java.domain.RequestBooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library")
public class BibliotecaController {
    @Autowired
    private LivrariaRepository repository;

    // Método para reivindicar informações no banco
    @GetMapping
    public ResponseEntity getAllBooks (){
        var allBooks = repository.findAll();
        return ResponseEntity.ok(allBooks);
    }

    // Método para inserir um livro novo no banco
    @PostMapping
    public ResponseEntity registerBook(@RequestBody RequestBooks data){
        Livraria newLivraria = new Livraria(data);
        System.out.println(data);
        repository.save(newLivraria);
        return ResponseEntity.ok().build();
    }

    // Método para atualizar o livro no banco
    @PutMapping("/{id}")
    public ResponseEntity updateBook(@PathVariable int id, @RequestBody RequestBooks data){
        var optionalBook = repository.findById(id);

        if (optionalBook.isPresent()) {
            var existingBook = optionalBook.get();
            existingBook.setLivro(data.livro());
            existingBook.setData_lancamento(data.data_lancamento());
            existingBook.setAutor(data.autor());
            existingBook.setGenero(data.genero());
            existingBook.setEditora(data.editora());
            repository.save(existingBook);
            return ResponseEntity.ok(existingBook);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    // Método para fazer o delete do livro no banco
    @DeleteMapping("/{id}")
    public ResponseEntity deleteBook(@PathVariable int id){
        var optionalBook = repository.findById(id);

        if (optionalBook.isPresent()) {
            var existingBook = optionalBook.get();

            repository.delete(existingBook);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

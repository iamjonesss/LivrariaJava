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

    @GetMapping
    public ResponseEntity getAllBooks (){
        var allBooks = repository.findAll();
        return ResponseEntity.ok(allBooks);
    }

    @PostMapping
    public ResponseEntity registerBook(@RequestBody RequestBooks data){
        Livraria newLivraria = new Livraria(data);
        System.out.println(data);
        repository.save(newLivraria);
        return ResponseEntity.ok().build();
    }

}

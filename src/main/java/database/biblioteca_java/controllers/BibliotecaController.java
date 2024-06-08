package database.biblioteca_java.controllers;

import database.biblioteca_java.domain.LivrariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

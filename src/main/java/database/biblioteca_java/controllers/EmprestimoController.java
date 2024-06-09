package database.biblioteca_java.controllers;

import database.biblioteca_java.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private ClientsRepository clientsRepository;

    @Autowired
    private LivrariaRepository livrariaRepository;

    @GetMapping
    public ResponseEntity getAllEmprestimos() {
        var allEmprestimos = emprestimoRepository.findAll();
        return ResponseEntity.ok(allEmprestimos);
    }

    @PostMapping
    public ResponseEntity registerEmprestimo(@RequestBody RequestsEmprestimo data) {
        Optional<Clientes> cliente = clientsRepository.findByNomeCliente(data.nomeCliente());
        Optional<Livraria> livro = livrariaRepository.findByLivro(data.nomeLivro());

        if (cliente.isPresent() && livro.isPresent()) {
            Emprestimo newEmprestimo = new Emprestimo();
            newEmprestimo.setCliente(cliente.get());
            newEmprestimo.setLivro(livro.get());
            newEmprestimo.setDataEmprestimo(data.dataEmprestimo());
            newEmprestimo.setDataDevolucao(data.dataDevolucao());
            emprestimoRepository.save(newEmprestimo);
            return ResponseEntity.ok(newEmprestimo);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateEmprestimo(@PathVariable int id, @RequestBody RequestsEmprestimo data) {
        var optionalEmprestimo = emprestimoRepository.findById(id);

        if (optionalEmprestimo.isPresent()) {
            Emprestimo existingEmprestimo = optionalEmprestimo.get();
            Optional<Clientes> cliente = clientsRepository.findByNomeCliente(data.nomeCliente());
            Optional<Livraria> livro = livrariaRepository.findByLivro(data.nomeLivro());

            if (cliente.isPresent() && livro.isPresent()) {
                existingEmprestimo.setCliente(cliente.get());
                existingEmprestimo.setLivro(livro.get());
                existingEmprestimo.setDataEmprestimo(data.dataEmprestimo());
                existingEmprestimo.setDataDevolucao(data.dataDevolucao());
                emprestimoRepository.save(existingEmprestimo);
                return ResponseEntity.ok(existingEmprestimo);
            } else {
                return ResponseEntity.badRequest().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping
    public ResponseEntity deleteEmprestimo(@RequestParam String nomeCliente, @RequestParam String nomeLivro) {
        Optional<Clientes> cliente = clientsRepository.findByNomeCliente(nomeCliente);
        Optional<Livraria> livro = livrariaRepository.findByLivro(nomeLivro);

        if (cliente.isPresent() && livro.isPresent()) {
            var emprestimos = emprestimoRepository.findAll();
            for (Emprestimo emprestimo : emprestimos) {
                if (emprestimo.getCliente().equals(cliente.get()) && emprestimo.getLivro().equals(livro.get())) {
                    emprestimoRepository.delete(emprestimo);
                    return ResponseEntity.ok().build();
                }
            }
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}

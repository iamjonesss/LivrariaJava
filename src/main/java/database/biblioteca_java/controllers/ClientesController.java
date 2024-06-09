package database.biblioteca_java.controllers;

import database.biblioteca_java.domain.Clientes;
import database.biblioteca_java.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")

public class ClientesController {
    @Autowired
    private ClientsRepository repository;

    // Método para reivindicar informações no banco
    @GetMapping
    public ResponseEntity getAllClients (){
        var allClients = repository.findAll();
        return ResponseEntity.ok(allClients);
    }

    // Método para inserir um cliente novo no banco
    @PostMapping
    public ResponseEntity saveClient(@RequestBody RequestsClientes client){
        Clientes newClient = new Clientes(client);
        System.out.println(client);
        repository.save(newClient);
        return ResponseEntity.ok(newClient);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateClient(@PathVariable int id, @RequestBody RequestsClientes client){
        var optionalClient = repository.findById(id);

        if(optionalClient.isPresent()){
            var existingClient = optionalClient.get();
            existingClient.setNomeCliente(client.NomeCliente());
            existingClient.setDataNascimento(client.DataNascimento());
            existingClient.setSexoCliente(client.SexoCliente());
            existingClient.setCpfCliente(client.CpfCliente());
            existingClient.setEnderecoCliente(client.EnderecoCliente());
            existingClient.setTelefoneCliente(client.TelefoneCliente());
            repository.save(existingClient);
            return ResponseEntity.ok(existingClient);

        } else{
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable int id){
        var optionalClient = repository.findById(id);

        if (optionalClient.isPresent()) {
            var existingClient = optionalClient.get();

            repository.delete(existingClient);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }

}
}

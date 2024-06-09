package database.biblioteca_java.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClientsRepository extends JpaRepository<Clientes, Integer> {
    Optional<Clientes> findByNomeCliente(String nomeCliente);

}
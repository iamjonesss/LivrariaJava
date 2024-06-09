package database.biblioteca_java.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LivrariaRepository extends JpaRepository<Livraria, Integer> {
    Optional<Livraria> findByLivro(String livro);
}
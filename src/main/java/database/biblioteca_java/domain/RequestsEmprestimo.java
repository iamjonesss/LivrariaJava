package database.biblioteca_java.domain;

import java.time.LocalDate;

public record RequestsEmprestimo(String nomeCliente, String nomeLivro, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
}

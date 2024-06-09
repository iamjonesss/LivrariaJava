package database.biblioteca_java.domain;

// DTO dos livros, onde irá apenas repassar as informações das colunas da tabela do banco
public record RequestBooks(String livro, String data_lancamento, String autor, String genero, String editora) {
}


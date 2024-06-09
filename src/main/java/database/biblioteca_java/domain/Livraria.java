package database.biblioteca_java.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name="livraria")
@Entity(name="livraria")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id_cliente")
public class Livraria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String livro;
    private String Data_lancamento;
    private String Autor;
    private String Genero;
    private String Editora;

    @OneToMany(mappedBy = "livro")
    private List<Emprestimo> emprestimos;

    public Livraria(RequestBooks requestBooks){
        this.livro = requestBooks.livro();
        this.Data_lancamento = requestBooks.data_lancamento();
        this.Autor = requestBooks.autor();
        this.Genero = requestBooks.genero();
        this.Editora = requestBooks.editora();
    }
}
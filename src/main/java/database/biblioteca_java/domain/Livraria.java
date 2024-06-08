package database.biblioteca_java.domain;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

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

    private String Livro;
    private String Data_lancamento;
    private String Autor;
    private String Genero;
    private String Editora;

    public Livraria(RequestBooks requestBooks){
        this.Livro = requestBooks.livro();
        this.Data_lancamento = requestBooks.data_lancamento();
        this.Autor = requestBooks.autor();
        this.Genero = requestBooks.genero();
        this.Editora = requestBooks.editora();
    }
}
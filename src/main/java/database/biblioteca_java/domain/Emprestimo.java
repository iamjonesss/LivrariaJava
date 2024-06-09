package database.biblioteca_java.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "Emprestimo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idEmprestimo")
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmprestimo;

    @ManyToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "id_cliente")
    private Clientes cliente;

    @ManyToOne
    @JoinColumn(name = "idLivro", referencedColumnName = "id")
    private Livraria livro;

    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
}

package database.biblioteca_java.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name="Clientes")
@Entity(name="Clientes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id_cliente")
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cliente;

    private String NomeCliente;
    private String DataNascimento;
    private String SexoCliente;
    private String CpfCliente;
    private String EnderecoCliente;
    private String TelefoneCliente;

    @OneToMany(mappedBy = "cliente")
    private List<Emprestimo> emprestimos;

    public Clientes (RequestsClientes requestsClientes){
        this.NomeCliente = requestsClientes.NomeCliente();
        this.DataNascimento = requestsClientes.DataNascimento();
        this.SexoCliente = requestsClientes.SexoCliente();
        this.CpfCliente = requestsClientes.CpfCliente();
        this.EnderecoCliente = requestsClientes.EnderecoCliente();
        this.TelefoneCliente = requestsClientes.TelefoneCliente();
    }
}
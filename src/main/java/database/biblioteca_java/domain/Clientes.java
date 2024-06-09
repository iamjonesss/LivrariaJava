package database.biblioteca_java.domain;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

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

    public Clientes (RequestsClientes requestsClientes){
        this.NomeCliente = requestsClientes.NomeCliente();
        this.DataNascimento = requestsClientes.DataNascimento();
        this.SexoCliente = requestsClientes.SexoCliente();
        this.CpfCliente = requestsClientes.CpfCliente();
        this.EnderecoCliente = requestsClientes.EnderecoCliente();
        this.TelefoneCliente = requestsClientes.TelefoneCliente();
    }
}
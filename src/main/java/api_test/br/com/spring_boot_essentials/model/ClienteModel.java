package api_test.br.com.spring_boot_essentials.model;

import api_test.br.com.spring_boot_essentials.service.DividaService;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Clientes")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private String cpf;
    private boolean bloqueado = false;

    @OneToMany(mappedBy = "vendas")
    private List<VendaModel> vendas = new ArrayList<>();

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<DividaModel> dividas = new ArrayList<>();

    public ClienteModel(Integer id, String nome, String telefone, String email, String endereco) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public ClienteModel(String nome, String telefone, String email, String endereco) {}
}

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
@Table(name = "clientes")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String telefone;
    private String email;
    private String cpf;
    private boolean bloqueado = false;

    @Enumerated
    private EnderecoModel endereco;

    @OneToMany(mappedBy = "cliente")
    private List<VendaModel> vendas = new ArrayList<>();

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<DividaModel> dividas = new ArrayList<>();

    public ClienteModel(Integer id, String nome, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public ClienteModel() {}
}

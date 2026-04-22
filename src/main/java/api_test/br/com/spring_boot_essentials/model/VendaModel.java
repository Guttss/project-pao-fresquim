package api_test.br.com.spring_boot_essentials.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "vendas")
public class VendaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private LocalDate dataVenda;
    private Double valorTotal;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "venda_id")
    private List<ProdutoModel> produtos = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pagamento_id", referencedColumnName = "id")
    private PagamentoModel pagamento;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private ClienteModel cliente;

    public VendaModel(Integer id, LocalDate dataVenda, Double valorTotal) {
        this.id = id;
        this.dataVenda = dataVenda;
        this.valorTotal = valorTotal;
    }

    public VendaModel() {}
}

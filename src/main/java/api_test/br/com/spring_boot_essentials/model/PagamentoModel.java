package api_test.br.com.spring_boot_essentials.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "pagamento")
public class PagamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tipo;
    private Double valor;

    public PagamentoModel(Integer id, String tipo, Double valor) {
        this.id = id;
        this.tipo = tipo;
        this.valor = valor;
    }

    public PagamentoModel() {}
}

package api_test.br.com.spring_boot_essentials.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "dividas")
public class DividaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double valor;

    @Column(nullable = false)
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteModel cliente;

    public DividaModel(Integer id, Double valor, LocalDate data) {
        this.id = id;
        this.valor = valor;
        this.data = data;
    }

    public DividaModel() {}
}

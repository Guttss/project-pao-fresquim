package api_test.br.com.spring_boot_essentials.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "produtos")
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Integer quantidade;
    private Double preco;

    @Column(nullable = false)
    private String codigoBarras;

    public ProdutoModel(Integer id, String nome, Double preco, Integer quantidade, String codigoBarras) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.codigoBarras = codigoBarras;
    }

    public ProdutoModel() {}
}

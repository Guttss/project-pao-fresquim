package api_test.br.com.spring_boot_essentials.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private String categoria;

    @Column(nullable = false, unique = true) // Garante que o código de barras seja único e não nulo
    private String codigoBarras;

    public ProdutoModel(Integer id, String nome, Double preco, Integer quantidade, String codigoBarras, String categoria) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.codigoBarras = codigoBarras;
        this.categoria = categoria;
    }

    public ProdutoModel() {}
}

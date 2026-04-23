package api_test.br.com.spring_boot_essentials.model;


import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class EnderecoModel {

    private String rua;
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;
    private String complemento;
}

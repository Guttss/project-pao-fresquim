package api_test.br.com.spring_boot_essentials.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteRequestDTO {

    private String nome;

    private String telefone;

    private String email;

    private String cpf;
}
package api_test.br.com.spring_boot_essentials.service;


import api_test.br.com.spring_boot_essentials.model.ClienteModel;
import api_test.br.com.spring_boot_essentials.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;



    public ClienteModel converterParaModel(ClienteRequestDTO dto){

        ClienteModel cliente = new ClienteModel();
        cliente.setNome(dto.getNome());
        cliente.setTelefone(dto.getTelefone());
        cliente.setEmail(dto.getEmail());
        cliente.setCpf(dto.getCpf());

        return cliente;
    }

    public ClienteResponseDTO converterParaDTO(ClienteModel cliente){

        ClienteResponseDTO dto = new ClienteResponseDTO();

        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setTelefone(cliente.getTelefone());
        dto.setEmail(cliente.getEmail());

    return dto;
    }  

    public ClienteResponseDTO cadastrarCliente(
            ClienteRequestDTO dto){

        ClienteModel cliente =
                converterParaModel(dto);

        cliente = clienteRepository.save(cliente);

        return converterParaDTO(cliente);
    }

    public boolean validarSerasa(Integer clienteId){

        ClienteModel cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));

        boolean checarCliente = checarClienteSerasa(cliente.getCpf());

        if(checarCliente) {
            bloquearCliente(cliente);
        }
        return false;
    }

    public void bloquearCliente(ClienteModel cliente){

        cliente.setBloqueado(true);
        clienteRepository.save(cliente);
        System.out.println("O Cliente " + cliente.getNome() + " foi bloqueado preventivamente!");
    }

    public boolean checarClienteSerasa(String cpf){

        return cpf != null && cpf.startsWith("0");
    }
}

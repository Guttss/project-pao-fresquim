package api_test.br.com.spring_boot_essentials.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api_test.br.com.spring_boot_essentials.model.ClienteModel;
import api_test.br.com.spring_boot_essentials.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public ClienteModel cadastrarCliente(ClienteModel clienteModel) {
        if(clienteModel.getNome() == null || clienteModel.getNome(). isBlank() || clienteModel.getCpf() == null || clienteModel.getCpf().isBlank()) {
            throw new RuntimeException("Nome e CPF são obrigatórios!");
        }// Verifica se o nome e o CPF do cliente são nulos ou vazios. Se forem, lança uma exceção informando que ambos são obrigatórios.

        if(clienteRepository.existsByCpf(clienteModel.getCpf())) {
            throw new RuntimeException("CPF já cadastrado!");
        }
        boolean clienteNegativado = checarClienteSerasa(clienteModel.getCpf()); // Chama o método checarClienteSerasa para verificar se o cliente está negativado no Serasa, passando o CPF do cliente como argumento. O resultado é armazenado na variável clienteNegativado.
        
        if(clienteNegativado) {
            throw new RuntimeException("Cliente negativado no Serasa!");
        }

        return clienteRepository.save(clienteModel); // Salva o cliente no banco de dados usando o método save do clienteRepository e retorna o cliente salvo.
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

        if(cpf == null) {
            return true;
        }else {
            return false;
        } //retorna true se o cliente estiver negativado no serasa.
        
    }
}

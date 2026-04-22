package api_test.br.com.spring_boot_essentials.service;

import api_test.br.com.spring_boot_essentials.model.FuncionarioModel;
import api_test.br.com.spring_boot_essentials.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioModel cadastrarFuncionario(FuncionarioModel funcionario){
        return funcionarioRepository.save(funcionario);
    }
}

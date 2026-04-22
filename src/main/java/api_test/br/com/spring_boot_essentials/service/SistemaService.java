package api_test.br.com.spring_boot_essentials.service;

import api_test.br.com.spring_boot_essentials.model.ClienteModel;
import api_test.br.com.spring_boot_essentials.model.FuncionarioModel;
import api_test.br.com.spring_boot_essentials.model.ProdutoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SistemaService {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private MonitoramentoService monitoramentoService;

    @Autowired
    private PontoService pontoService;

    @Autowired
    private FuncionarioService funcionarioService;

    public ProdutoModel cadastarProduto(ProdutoModel produtoModel) {

        if(produtoModel.getPreco() <= 0) {
            System.out.println("Preço invalido para cadastrar");
        }

        return produtoService.salvar(produtoModel);
    }

    public ClienteModel cadastarCliente(ClienteModel clienteModel) {

        return clienteService.cadastrarCliente(clienteModel);
    }

    public String abrirCameras(){
        return monitoramentoService.visualizarCameras();
    }

    public void registrarEntradaFuncionario (Integer funcionarioId){
        pontoService.registrarEntrada(funcionarioId);
    }

    public void registrarSaidaFuncionario (Integer pontoId){
        pontoService.registarSaida(pontoId);
    }

    public FuncionarioModel cadastrarFuncionario (FuncionarioModel funcionarioModel){
        return funcionarioService.cadastrarFuncionario(funcionarioModel);
    }

}

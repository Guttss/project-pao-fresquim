package api_test.br.com.spring_boot_essentials.service;

import api_test.br.com.spring_boot_essentials.model.PagamentoModel;
import api_test.br.com.spring_boot_essentials.model.VendaModel;
import api_test.br.com.spring_boot_essentials.repository.PagamentoRepository;
import api_test.br.com.spring_boot_essentials.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private VendaRepository vendaRepository;

    public PagamentoModel registrarPagamento(Integer vendaId, PagamentoModel pagamentoModel) {

        VendaModel vendaModel = vendaRepository.findById(vendaId).orElseThrow(() -> new RuntimeException("Venda inexistente"));

        if(pagamentoModel.getValor().equals(vendaModel.getValorTotal())){
            System.out.println("Pagamento realizado com sucesso!");
        }
        else{
            System.out.println("Pagamento negado");
        }

        vendaModel.setPagamento(pagamentoModel);

        vendaRepository.save(vendaModel);

        return vendaModel.getPagamento();
    }
}

package api_test.br.com.spring_boot_essentials.service;

import api_test.br.com.spring_boot_essentials.model.ProdutoModel;
import api_test.br.com.spring_boot_essentials.model.VendaModel;
import api_test.br.com.spring_boot_essentials.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public VendaModel calcularTotal(VendaModel vendaModel) {

        List<ProdutoModel> produtos = vendaModel.getProdutos();

        double valorTotal = 0;

        if(produtos != null) {
            for (ProdutoModel produto : produtos) {
                valorTotal += produto.getPreco();
            }
        }
        vendaModel.setValorTotal(valorTotal);

        return vendaRepository.save(vendaModel);
    }

    public String emitirNotaFiscal(VendaModel vendaModel) {

        StringBuilder sb = new StringBuilder();
        sb.append("NOTA FISCAL\n");

        for(ProdutoModel produto : vendaModel.getProdutos()) {
            sb.append("Produto: ").append(produto.getNome())
                    .append("\n Preco: ").append(produto.getPreco())
                    .append("\nQuantidade: ").append(produto.getQuantidade());
        }

        sb.append("\n\n Valor total da compra: R$ ").append(vendaModel.getValorTotal());

        return sb.toString();

    }
}

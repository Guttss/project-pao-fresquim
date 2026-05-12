package api_test.br.com.spring_boot_essentials.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api_test.br.com.spring_boot_essentials.model.ProdutoModel;
import api_test.br.com.spring_boot_essentials.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

   public ProdutoModel salvar(ProdutoModel produtoModel) {

    if(produtoRepository.existsByCodigoBarras(produtoModel.getCodigoBarras())){
        throw new RuntimeException("Código de barras já cadastrado!");
    }// Validações adicionais para garantir que os dados sejam consistentes

    if(produtoModel.getPreco() <= 0){
        throw new RuntimeException("Preço inválido!");
    }

    if(produtoModel.getQuantidade() < 0){
        throw new RuntimeException("Quantidade inválida!");
    }

    return produtoRepository.save(produtoModel);
}

    public void deletarProduto(Integer id){
        produtoRepository.deleteById(id);
    }

    public List<ProdutoModel> listar() {
        return produtoRepository.findAll();
    }
}

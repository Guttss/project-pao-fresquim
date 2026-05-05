package api_test.br.com.spring_boot_essentials.service;

import api_test.br.com.spring_boot_essentials.model.ProdutoModel;
import api_test.br.com.spring_boot_essentials.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoModel salvar(ProdutoModel produtoModel) {
        return produtoRepository.save(produtoModel);
    }

    public List<ProdutoModel> listar() {
        return produtoRepository.findAll();
    }
}

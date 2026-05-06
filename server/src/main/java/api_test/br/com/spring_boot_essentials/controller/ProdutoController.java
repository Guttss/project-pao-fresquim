package api_test.br.com.spring_boot_essentials.controller;

import api_test.br.com.spring_boot_essentials.model.ProdutoModel;
import api_test.br.com.spring_boot_essentials.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    public final ProdutoService produtoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProdutoModel> listarProdutos() {
        return produtoService.listar();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoModel adicionarProduto(@RequestBody ProdutoModel produtoModel) {
        return produtoService.salvar(produtoModel);
    }
}

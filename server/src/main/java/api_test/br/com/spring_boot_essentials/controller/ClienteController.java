package api_test.br.com.spring_boot_essentials.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import api_test.br.com.spring_boot_essentials.model.ClienteModel;
import api_test.br.com.spring_boot_essentials.service.ClienteService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteModel salvar(@RequestBody ClienteModel clienteModel) {
        return clienteService.cadastrarCliente(clienteModel);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Boolean status(@PathVariable Integer id){
        return clienteService.validarSerasa(id);
    }

}

package api_test.br.com.spring_boot_essentials.service;

import api_test.br.com.spring_boot_essentials.model.DividaModel;
import api_test.br.com.spring_boot_essentials.repository.DividaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DividaService {

    @Autowired
    private DividaRepository dividaRepository;

    public DividaModel registrarDivida(DividaModel novaDivida) {

        return dividaRepository.save(novaDivida);
    }

    public void enviarCobranca(DividaModel divida) {

        String email = divida.getCliente().getEmail();
        System.out.println("Enviando cobranca de R$" + divida.getValor() + " para: " + email);
    }
}

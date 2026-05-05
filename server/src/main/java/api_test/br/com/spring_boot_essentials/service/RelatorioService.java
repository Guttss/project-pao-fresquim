package api_test.br.com.spring_boot_essentials.service;

import api_test.br.com.spring_boot_essentials.model.VendaModel;
import api_test.br.com.spring_boot_essentials.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RelatorioService {

    @Autowired
    private VendaRepository vendaRepository;

    public String gerarRelatorio(){

        List<VendaModel> todasVendas = vendaRepository.findAll();

        StringBuilder sb = new StringBuilder();

        sb.append("RELATORIO DE VENDAS");

        for(VendaModel vendaModel : todasVendas){
            sb.append("ID: ").append(vendaModel.getId())
                    .append("| Total: ").append(vendaModel.getValorTotal())
                    .append("\n");
        }

        return sb.toString();
    }

    public List<VendaModel> filtrarPorPeriodo(LocalDate inicio, LocalDate fim){

        return vendaRepository.findByDataVendaBetween(inicio, fim);
    }
}

package api_test.br.com.spring_boot_essentials.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonitoramentoService {

    public String visualizarCameras(){

        return "Conectando todas as cameras";
    }

    public String acessoRemoto(String ipDispositivo){

        return "Acesso remoto liberado para o dispositivo " + ipDispositivo;
    }
}

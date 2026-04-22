package api_test.br.com.spring_boot_essentials.service;

import api_test.br.com.spring_boot_essentials.model.FuncionarioModel;
import api_test.br.com.spring_boot_essentials.model.PontoModel;
import api_test.br.com.spring_boot_essentials.repository.FuncionarioRepository;
import api_test.br.com.spring_boot_essentials.repository.PontoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class PontoService {

    @Autowired
    private PontoRepository pontoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public PontoModel registrarEntrada(Integer idFuncionario){

        FuncionarioModel funcionario = funcionarioRepository.findById(idFuncionario).orElseThrow(() -> new RuntimeException("Funcionario não encontrado!"));

        PontoModel ponto = new PontoModel();
        ponto.setFuncionario(funcionario);
        ponto.setData(LocalDate.now());
        ponto.setHoraEntrada(LocalTime.now());

        return pontoRepository.save(ponto);

    }

    public PontoModel registarSaida(Integer pontoId){

        PontoModel ponto = pontoRepository.findById(pontoId).orElseThrow(() -> new RuntimeException("Registro de ponto não encontrado!"));

        ponto.setHoraSaida(LocalTime.now());

        return pontoRepository.save(ponto);
    }
}

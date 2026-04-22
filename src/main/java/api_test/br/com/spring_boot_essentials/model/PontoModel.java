package api_test.br.com.spring_boot_essentials.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "ponto")
public class PontoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    private LocalDateTime horaEntrada;

    @Column(nullable = false)
    private LocalDateTime horaSaida;

    public PontoModel(Integer id, LocalDate data, LocalDateTime horaEntrada, LocalDateTime horaSaida) {
        this.id = id;
        this.data = data;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
    }

    public PontoModel() {}
}

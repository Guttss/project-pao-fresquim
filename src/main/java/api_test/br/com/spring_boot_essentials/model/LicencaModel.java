package api_test.br.com.spring_boot_essentials.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="licencas")
public class LicencaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="tipoLicenca")
    private String tipoLicenca;

    @Column(name="dataInicio")
    private Date dataInicio;

    @Column(name="dataFim")
    private Date dataFim;

    @ManyToOne()
    @JoinColumn(name="funcionario_id")
    private FuncionarioModel funcionario;


}

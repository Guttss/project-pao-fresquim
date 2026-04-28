package api_test.br.com.spring_boot_essentials.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="notificacoes")
public class NotificacaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notificacao")
    private Integer id;

    @Column(name = "data_envio")
    private LocalDate dataEnvio;

    @Column(name = "status_entrega")
    private boolean statusEntrega;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_divida")
    private DividaModel divida;
}

package api_test.br.com.spring_boot_essentials.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="cameras")
public class CameraModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nome_local")
    private String nomeLocal;

    @Column(name="status")
    private boolean status;

    @Column(name="url_stram")
    private String urlStream;
}

package ada.tech.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PET")
    private Long id;

    @Column(name = "NO_PET", nullable = false)
    private String nome;

    @Column(name = "NO_ESPECIE", nullable = false)
    private String especie;

    @Column(name = "NO_RACA")
    private String raca;

    @Column(name = "NU_IDADE")
    private Integer idade;

    @Column(name = "NU_PESO", precision = 3, scale = 2)
    private BigDecimal peso;

    @Column(name = "NO_DONO",nullable = false)
    private String dono;

}

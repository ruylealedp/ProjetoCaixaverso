package ada.tech.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddPetRequestDTO {
    private String nome;

    private String especie;

    private String raca;

    private Integer idade;

    private BigDecimal peso;

    private String dono;
}

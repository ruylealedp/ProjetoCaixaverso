package ada.tech.entity;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Produto {
    private String nome;
    private Double preco;
    private String descricao;
}

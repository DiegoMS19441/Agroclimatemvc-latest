package br.com.fiap.agroclimate.agroclimatemvc.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "Solo")
public class Solo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_solo")
    private Long id;

    @Column(name = "nm_solo", length = 30, nullable = false)
    @NotBlank(message = "Verifique o campo")
    private String nome;

    @OneToOne(mappedBy = "solo")
    private Fazenda fazenda;
}

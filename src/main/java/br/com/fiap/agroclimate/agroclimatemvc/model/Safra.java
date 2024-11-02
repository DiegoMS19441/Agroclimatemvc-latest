package br.com.fiap.agroclimate.agroclimatemvc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Safra")
@EntityListeners(AuditingEntityListener.class)
public class Safra {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_safra")
    private Long id;

    @Column(name = "nm_safra")
    private String nome;

    @Column(name = "dt_inicio", nullable = false)
    @Past(message = "A data deve ser no passado")
    @NotNull(message = "Por favor preencha o campo")
    private LocalDate dataInicio;

    @Column(name = "dt_termino", nullable = false)
    @NotNull(message = "Por favor preencha o campo")
    private LocalDate dataTermino;

    @ManyToOne
    @JoinColumn(name = "id_fazenda")
    private Fazenda fazenda;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_colheita")
    private Colheita colheita;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_info_plantacao")
    private InfoPlantacao infoPlantacao;

}

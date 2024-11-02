package br.com.fiap.agroclimate.agroclimatemvc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "COLHEITA")
public class Colheita {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_COLHEITA")
    private Long id;

    @Column(name = "DATA_COLHEITA", nullable = false)
    @NotNull(message = "Verifique o campo")
    private LocalDate dataColheita;

    @Column(name = "QNT_COLHEITA")
    private Integer quantidade;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_SAFRA")
    private Safra safra;
}

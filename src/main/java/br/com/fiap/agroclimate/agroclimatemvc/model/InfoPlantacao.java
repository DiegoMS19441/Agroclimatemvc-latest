package br.com.fiap.agroclimate.agroclimatemvc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Plantacao")
public class InfoPlantacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_plantacao")
    private Long id;

    @Column(name = "data_plantacao")
    @NotNull(message = "Verifique o campo")
    private LocalDate dataPlantacao;

    @Column(name = "item_plantado")
    @NotBlank(message = "Verifique o campo")
    private String itemPlantado;

    @Column(name = "area_plantada")
    @NotNull(message = "Verifique o campo")
    @Min(value = 1, message = "O valor não pode ser negativo")
    private Integer areaPlantada;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_SAFRA")
    private Safra safra;
}

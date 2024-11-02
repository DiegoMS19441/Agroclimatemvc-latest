package br.com.fiap.agroclimate.agroclimatemvc.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Fazenda")
public class Fazenda {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_fazenda")
    private Long id;

    @Column(name = "cnpj_fazenda", length = 14, nullable = false, unique = true)
    @NotBlank(message = "Esse campo precisa de atenção")
    private String cnpj;

    @Column(name = "nm_fazenda", nullable = false, unique = true)
    @NotBlank(message = "Esse campo precisa de atenção")
    private String razaoSocial;

    @Column(name = "cep", nullable = false, length = 8)
    @NotBlank(message = "Esse campo precisa de atenção")
    private String cep;

    @Column(name = "logradouro", nullable = false)
    @NotBlank(message = "Esse campo precisa de atenção")
    private String logradouro;

    @Column(name = "nr_endereco", nullable = false)
    @NotBlank(message = "Esse campo precisa de atenção")
    private String numero;

    @Column(nullable = false, length = 30)
    @Email(message = "Esse campo precisa de atenção")
    @NotBlank(message = "Esse campo precisa de atenção")
    private String email;

    @Column(name = "tel_fazenda")
    @Size(min =10, max = 10, message = "Número inválido")
    @NotBlank(message = "Telefone é um campo obrigatório")
    private String telefone;

    @Column(name = "tamanho_fazenda", precision = 9)
    @NotNull(message = "Tamanho é um campo obrigatório")
    @Size(min = 10)
    private Integer tamanhoFazenda;

    @Column(name = "clima_fazenda")
    private Clima clima;


    @ManyToOne
    @JoinColumn(name = "id_agricultor")
    private Agricultor agricultor;

    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_solo")
    private Solo solo;

    @OneToMany(mappedBy = "fazenda", cascade = CascadeType.ALL)
    private List<Safra> safras;

}

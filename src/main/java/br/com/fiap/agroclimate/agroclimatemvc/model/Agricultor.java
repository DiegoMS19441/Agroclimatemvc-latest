package br.com.fiap.agroclimate.agroclimatemvc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.List;

@Getter@Setter
@NoArgsConstructor@AllArgsConstructor
@Entity
@Table(name = "Agricultor")
public class Agricultor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_AGRICULTOR")
    private Long id;

    @Column(name = "NM_AGRIGULTOR", nullable = false)
    @Size(min = 3, max = 90)
    @NotBlank(message = "Nome é um campo obrigatório")
    private String nome;

    @Column(name = "CPF_AGRICULTOR",nullable = false)
    @NotBlank(message = "Verifique os seus dados")
    private String cpf;

    @Column(name = "DT_NASCIMENTO")
    @Past(message = "Verifique sua data de nascimento")
    @NotNull(message = "O campo deve ser preenchido")
    private LocalDate nascimento;

    @Column(name = "EMAIL_AGRICULTOR", unique = true, nullable = false)
    @Email(message = "Verifique seu e-mail")
    @NotBlank(message = "O Campo não pode ficar vazio")
    private String email;

    @Column(name = "tel_agricultor", nullable = false, unique = true)
    @Size(min = 10, max =10, message = "Verifique o número")
    @NotBlank(message = "O campo não pode ser nulo")
    private String telefone;

    @OneToMany(mappedBy = "agricultor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Fazenda> fazendas;

}

package br.com.fiap.agroclimate.agroclimatemvc.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter
public class UserForm {

    @NotBlank
    private String username;

    @NotBlank
    @Size(min = 6)
    private String password;

    @NotEmpty(message = "Esse campo não deve ser vazio")
    private List<String> roles;

}

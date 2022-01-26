package br.com.senai.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class AlunoInputDTO {

    @NotBlank
    private String nome;

}

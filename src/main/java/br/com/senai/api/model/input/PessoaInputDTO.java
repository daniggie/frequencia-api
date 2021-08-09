package br.com.senai.api.model.input;

import br.com.senai.api.model.UsuarioDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class PessoaInputDTO {

    @NotBlank
    private String nome;

    @NotNull
    private UsuarioInputDTO usuario;

    @NotBlank
    private String telefone;

}

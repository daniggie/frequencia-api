package br.com.senai.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaEntregaDTO {

    private String nomePessoa;
    private String emailPessoa;
    private UsuarioDTO usuario;
}


package br.com.senai.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;

@Getter
@Setter
public class RoleUsuarioDTO {

    private Long usuarios_id;
    private String role_nome_role;

}

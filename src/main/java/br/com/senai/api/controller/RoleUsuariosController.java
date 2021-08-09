package br.com.senai.api.controller;

import br.com.senai.api.assembler.RoleUsuarioAssembler;
import br.com.senai.api.model.RoleUsuarioDTO;
import br.com.senai.api.model.input.RoleUsuariosInputDTO;
import br.com.senai.domain.model.RoleUsuarios;
import br.com.senai.domain.service.RoleUsuariosService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/roleusuarios")
public class RoleUsuariosController {

    private RoleUsuarioAssembler roleUsuarioAssembler;
    private RoleUsuariosService roleUsuariosService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RoleUsuarioDTO cadastrar(@RequestBody RoleUsuariosInputDTO roleUsuariosInputDTO){

        RoleUsuarios novoRoleUsuarios = roleUsuarioAssembler.toEntity(roleUsuariosInputDTO);
        RoleUsuarios roleUsuarios = roleUsuariosService.cadastrar(novoRoleUsuarios);

        return roleUsuarioAssembler.toModel(roleUsuarios);
    }

    @GetMapping
    public List<RoleUsuarioDTO> listar(){
        return roleUsuariosService.listar();
    }
}

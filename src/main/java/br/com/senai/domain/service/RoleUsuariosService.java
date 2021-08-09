package br.com.senai.domain.service;

import br.com.senai.api.assembler.RoleUsuarioAssembler;
import br.com.senai.api.model.RoleUsuarioDTO;
import br.com.senai.domain.model.RoleUsuarios;
import br.com.senai.domain.repository.RoleUsuariosRepository;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RoleUsuariosService {

    private RoleUsuariosRepository roleUsuariosRepository;
    private RoleUsuarioAssembler roleUsuarioAssembler;


    public RoleUsuarios cadastrar(RoleUsuarios roleUsuarios){
        RoleUsuarios rule = roleUsuariosRepository.save(roleUsuarios);

        return rule;
    }

    public List<RoleUsuarioDTO> listar() {
        return roleUsuarioAssembler.toCollectionModel(roleUsuariosRepository.findAll());
    }
}

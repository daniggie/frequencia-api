package br.com.senai.api.assembler;

import br.com.senai.api.model.RoleUsuarioDTO;
import br.com.senai.api.model.input.RoleUsuariosInputDTO;
import br.com.senai.domain.model.RoleUsuarios;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class RoleUsuarioAssembler {

    private ModelMapper modelMapper;

    public RoleUsuarioDTO toModel(RoleUsuarios roleUsuarios){
        return modelMapper.map(roleUsuarios, RoleUsuarioDTO.class);
    }

    public RoleUsuarios toEntity(RoleUsuariosInputDTO roleUsuariosInputDTO){
        return modelMapper.map(roleUsuariosInputDTO, RoleUsuarios.class);
    }

    public List<RoleUsuarioDTO> toCollectionModel(List<RoleUsuarios> roleUsuarios){
        return roleUsuarios.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }
}

package br.com.senai.api.assembler;

import br.com.senai.api.model.FrequenciaDTO;
import br.com.senai.api.model.input.FrequenciaInputDTO;
import br.com.senai.domain.model.Frequencia;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class FrequenciaAssembler {

    private ModelMapper modelMapper;

    public FrequenciaDTO toModel(Frequencia frequencia){
        return modelMapper.map(frequencia,FrequenciaDTO.class);
    }

    public Frequencia toEntity(FrequenciaInputDTO frequenciaInputDTO){
        return modelMapper.map(frequenciaInputDTO, Frequencia.class);
    }

    public List<FrequenciaDTO> toCollectionModel(List<Frequencia> frequencia){
        return frequencia.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }
}

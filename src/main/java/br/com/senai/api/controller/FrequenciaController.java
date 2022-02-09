package br.com.senai.api.controller;


import br.com.senai.api.assembler.FrequenciaAssembler;
import br.com.senai.api.model.FrequenciaDTO;
import br.com.senai.api.model.input.FrequenciaInputDTO;
import br.com.senai.domain.model.Frequencia;
import br.com.senai.domain.service.FrequenciaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/frequencia")
public class FrequenciaController {

    private FrequenciaAssembler frequenciaAssembler;
    private FrequenciaService frequenciaService;

    @PostMapping
    public FrequenciaDTO chamada(@RequestBody FrequenciaInputDTO frequenciaInputDTO){
        Frequencia novaFrequencia = frequenciaAssembler.toEntity(frequenciaInputDTO);
        Frequencia frequencia = frequenciaService.chamada(novaFrequencia);
        return frequenciaAssembler.toModel(frequencia);
    }
}

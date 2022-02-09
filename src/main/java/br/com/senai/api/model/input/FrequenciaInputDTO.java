package br.com.senai.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class FrequenciaInputDTO {

    @NotBlank
    private long idAluno;
    private Boolean status;
}

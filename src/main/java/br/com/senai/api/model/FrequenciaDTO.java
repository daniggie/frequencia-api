package br.com.senai.api.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FrequenciaDTO {

    private long id;
    private long idAluno;
    private Boolean status;
}

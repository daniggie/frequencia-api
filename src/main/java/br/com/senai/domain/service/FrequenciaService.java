package br.com.senai.domain.service;

import br.com.senai.domain.model.Frequencia;
import br.com.senai.domain.repository.AlunoRepository;
import br.com.senai.domain.repository.FrequenciaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class FrequenciaService {

    private FrequenciaRepository frequenciaRepository;

    @Transactional
    public Frequencia chamada(Frequencia frequencia){
        Frequencia novoFrequencia = frequenciaRepository.save(frequencia);
        return novoFrequencia;
    }
}

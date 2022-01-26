package br.com.senai.domain.service;

import br.com.senai.api.assembler.AlunoAssembler;
import br.com.senai.api.model.AlunoDTO;
import br.com.senai.domain.model.Aluno;
import br.com.senai.domain.repository.AlunoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class AlunoService {

    private AlunoRepository alunoRepository;
    private AlunoAssembler alunoAssembler;

    @Transactional
    public Aluno cadastrar(Aluno pessoa){
        Aluno novaPessoa = alunoRepository.save(pessoa);
        return novaPessoa;
    }

    public List<AlunoDTO> listar(){
        return alunoAssembler.toCollectionModel(alunoRepository.findAll());
    }

    public Aluno editar(Long alunoId, Aluno aluno){
        aluno.setId(alunoId);
        return alunoRepository.save(aluno);
    }

    @Transactional
    public void remover(Long alunoId){
        alunoRepository.deleteById(alunoId);
    }

}

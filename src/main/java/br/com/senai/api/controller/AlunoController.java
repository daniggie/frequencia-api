package br.com.senai.api.controller;

import br.com.senai.api.assembler.AlunoAssembler;
import br.com.senai.api.model.AlunoDTO;
import br.com.senai.api.model.input.AlunoInputDTO;
import br.com.senai.domain.model.Aluno;
import br.com.senai.domain.repository.AlunoRepository;
import br.com.senai.domain.service.AlunoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private AlunoRepository alunoRepository;
    private AlunoService alunoService;
    private AlunoAssembler alunoAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlunoDTO cadastrar(@Valid @RequestBody AlunoInputDTO alunoInputDTO){
        Aluno novoAluno = alunoAssembler.toEntity(alunoInputDTO);
        Aluno aluno = alunoService.cadastrar(novoAluno);

        return alunoAssembler.toModel(aluno);
    }

    @GetMapping
    public List<AlunoDTO> listar(){
        return alunoService.listar();
    }

    @PutMapping("/editar/{alunoID}")
    public ResponseEntity<AlunoDTO> editar(@Valid @PathVariable Long alunoID, @RequestBody AlunoInputDTO alunoInputDTO){

        if (!alunoRepository.existsById(alunoID)){
            return  ResponseEntity.notFound().build();
        }

        Aluno novoAluno = alunoAssembler.toEntity(alunoInputDTO);
        Aluno aluno = alunoService.editar(alunoID, novoAluno);

        return ResponseEntity.ok(alunoAssembler.toModel(aluno));
    }


    @DeleteMapping("/{alunoId}")
    public ResponseEntity<Aluno> remover(@PathVariable Long alunoId){
        if (!alunoRepository.existsById(alunoId)){
            return  ResponseEntity.notFound().build();
        }
        alunoService.remover(alunoId);

        return ResponseEntity.noContent().build();
    }
}

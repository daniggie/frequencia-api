package br.com.senai.domain.service;

import br.com.senai.api.assembler.PessoaAssembler;
import br.com.senai.api.model.PessoaDTO;
import br.com.senai.domain.exception.ExceptionTratement;
import br.com.senai.domain.model.Pessoa;
import br.com.senai.domain.model.RoleUsuarios;
import br.com.senai.domain.repository.PessoaRepository;
import br.com.senai.domain.repository.RoleUsuariosRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;
    private PessoaAssembler pessoaAssembler;
    private RoleUsuariosRepository roleUsuariosRepository;

    @Transactional
    public Pessoa cadastrar(Pessoa pessoa){
//        boolean emailValdation = pessoaRepository.findByEmail(pessoa.getUsuario().getEmail()).isPresent();
//
//        if (emailValdation){
//            throw new ExceptionTratement("Esse e-mail já foi cadastrado");
//        }
        Pessoa novaPessoa = pessoaRepository.save(pessoa);

        RoleUsuarios roleUsuarios = new RoleUsuarios();
        roleUsuarios.setUsuarios_id(novaPessoa.getId());
        roleUsuarios.setRole_nome_role("ROLE_USER");
        roleUsuariosRepository.save(roleUsuarios);

        return novaPessoa;
    }


    public List<PessoaDTO> listar(){
        return pessoaAssembler.toCollectionModel(pessoaRepository.findAll());
    }


    public List<PessoaDTO> listarPorNome(String pessoaNome){
        return pessoaAssembler.toCollectionModel(pessoaRepository.findByNome(pessoaNome));
    }


    public List<PessoaDTO> listarNomeQueContem(String pessoaNome){
        return pessoaAssembler.toCollectionModel(pessoaRepository.findByNomeContaining(pessoaNome));
    }


    public Pessoa buscar(Long pessoaId){
        return pessoaRepository.findById(pessoaId).orElseThrow(() -> new ExceptionTratement("Pessoa Não econtrada"));
    }


    public ResponseEntity<PessoaDTO> buscarPorId(long pessoaId){
        return pessoaRepository.findById(pessoaId)
                .map(pessoa -> ResponseEntity.ok(pessoaAssembler.toModel(pessoa)))
                .orElse(ResponseEntity.notFound().build());
    }


    public Pessoa editar(Long idPessoa, Pessoa pessoa){
        pessoa.setId(idPessoa);
        return pessoaRepository.save(pessoa);
    }

    @Transactional
    public void remover(Long pessoaId){
        pessoaRepository.deleteById(pessoaId);
    }

}

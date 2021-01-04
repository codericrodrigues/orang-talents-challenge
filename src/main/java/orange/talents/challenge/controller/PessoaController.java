package orange.talents.challenge.controller;

import orange.talents.challenge.model.PessoaModel;
import orange.talents.challenge.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/pessoa")
public class PessoaController {
    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping(path = "/")
    public Iterable<PessoaModel> obtemTodos() {
        return this.pessoaRepository.findAll();
    }

    @GetMapping(path = "/{cpf}")
    public PessoaModel obtemPorCPF(@PathVariable String cpf) {
        boolean existsCpf = this.pessoaRepository.existsById(cpf);

        if(existsCpf) {
            return this.pessoaRepository.findById(cpf).get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada!");
        }
    }

    @PostMapping(path = "/")
    public ResponseEntity<PessoaModel> salvar(@Valid @RequestBody PessoaModel pessoa) {
        boolean existsCpf = this.pessoaRepository.existsById(pessoa.getCpf());
        boolean existsEmail = this.pessoaRepository.existsByEmail(pessoa.getEmail());

        if(existsCpf) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CPF ja existe no banco de dados!");
        } else if (existsEmail) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "E-mail ja existe no banco de dados!");
        } else {
            PessoaModel p = this.pessoaRepository.save(pessoa);
            return new ResponseEntity(p, HttpStatus.CREATED);
        }
    }

    @DeleteMapping(path = "/{cpf}")
    public void deletarPeloCPF(@PathVariable("cpf") String cpf) {
        boolean existsCpf = this.pessoaRepository.existsById(cpf);

        if(existsCpf) {
            this.pessoaRepository.deleteById(cpf);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada!");
        }
    }
}


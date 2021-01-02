package orange.talents.challenge.controller;

import orange.talents.challenge.model.PessoaModel;
import orange.talents.challenge.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/pessoa")
public class PessoaController {
    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping(path = "/")
    public Iterable<PessoaModel> obtemTodos() {
        var pessoas = this.pessoaRepository.findAll();
        return pessoas;
    }

    @PostMapping(path = "/")
    public PessoaModel salvar(@RequestBody PessoaModel pessoa) {
        return this.pessoaRepository.save(pessoa);
    }

}


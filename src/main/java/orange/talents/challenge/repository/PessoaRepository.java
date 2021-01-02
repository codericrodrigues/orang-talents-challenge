package orange.talents.challenge.repository;

import orange.talents.challenge.model.PessoaModel;
import org.springframework.data.repository.CrudRepository;

public interface PessoaRepository extends CrudRepository<PessoaModel, Integer> {
}

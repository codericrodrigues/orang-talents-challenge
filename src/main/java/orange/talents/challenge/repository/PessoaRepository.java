package orange.talents.challenge.repository;

import orange.talents.challenge.model.PessoaModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PessoaRepository extends CrudRepository<PessoaModel, String> {

    @Query(value =
            "SELECT " +
            "   CAST(" +
            "       IF(COUNT(*) > 0, " +
            "           'true', " +
            "           'false'" +
            "       ) " +
            "   AS JSON) " +
            "FROM pessoa WHERE email = :email",
            nativeQuery = true)
    boolean existsByEmail(@Param("email") String email);

}

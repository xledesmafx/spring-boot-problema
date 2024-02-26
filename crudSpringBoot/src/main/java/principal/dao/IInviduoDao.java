package principal.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import principal.domain.Individuo;


@Repository
public interface IInviduoDao extends CrudRepository<Individuo, Long> {

}

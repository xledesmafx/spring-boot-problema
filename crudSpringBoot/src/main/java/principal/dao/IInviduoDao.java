package principal.dao;

import principal.domain.Individuo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInviduoDao extends CrudRepository<Individuo, Long> {

}

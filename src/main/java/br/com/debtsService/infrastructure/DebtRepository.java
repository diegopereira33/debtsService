package br.com.debtsService.infrastructure;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import br.com.debtsService.domain.*;

public interface DebtRepository extends CrudRepository<Debt, Long> {

	List<Debt> findAll();
}

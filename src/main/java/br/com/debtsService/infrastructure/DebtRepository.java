package br.com.debtsService.infrastructure;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
//import java.util.Optional;

import br.com.debtsService.domain.*;

public interface DebtRepository extends CrudRepository<Debt, Long> {

	List<Debt> findAll();
	
	@Query("select d FROM debt d WHERE d.name = (:name)")
    List<Debt> findByName(@Param("name") String name);
	
	@Query("select d FROM debt d WHERE d.dueDate >= (:initialDate) and d.dueDate < (:finalDate) ")
    List<Debt> findByDate(@Param("initialDate") String initialDate, @Param("finalDate") String finalDate );

	@Query("select d FROM debt d WHERE d.category = (:category)")
    List<Debt> findByCategory(@Param("category") String category);

}

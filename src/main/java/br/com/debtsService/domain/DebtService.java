package br.com.debtsService.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.debtsService.infrastructure.DebtRepository;

@Service
public class DebtService {

	private DebtRepository repository;
	
	public DebtService(DebtRepository repository) {
		this.repository = repository;
	}
	
	public List<Debt> findAll() { 
		return repository.findAll(); 	
	}
	
	public Optional<Debt> findById(Long id) {
		return repository.findById(id);
	}
	
	public List<Debt> findByName(String name) {
		return repository.findByName(name);
	}
	
	public List<Debt> findByDate(String initialDate, String finalDate) {
		return repository.findByDate(initialDate, finalDate);
	}
	
	public List<Debt> findByCategory(String category) {
		return repository.findByCategory(category);
	}
	
	public Debt create(Debt debt) {
		return repository.save(debt);
	}
	
	public ResponseEntity<Debt> update (Long id, Debt debt) {
		return repository.findById(id).map(record -> {
			record.setValue(debt.getValue());
			record.setCategory(debt.getCategory());
			record.setPayDate(debt.getPayDate());
			record.setDescription(debt.getDescription());
			record.setDueDate(debt.getDueDate());
			record.setName(debt.getName());
			record.setStatus(debt.getStatus());
			record.setParcelNumber(debt.getParcelNumber());
			Debt newDebt = repository.save(record);
			return ResponseEntity.ok().body(newDebt);
		}).orElse(ResponseEntity.notFound().build());
	}
	
	public Optional<?> delete (Long id) {
		return repository.findById(id).map(record -> {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		});
	}
	
}

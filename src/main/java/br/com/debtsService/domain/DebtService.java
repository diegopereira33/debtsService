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
		return repository.findAllByOrderByNameAsc(); 	
	}
	
	public Optional<Debt> findById(Long id) {
		return repository.findById(id);
	}
	
	public Debt create(Debt debt) {
		return repository.save(debt);
	}
	
	public ResponseEntity<Debt> update (Long id, Debt debt) {
		return repository.findById(id).map(record -> {
			record.setAllValue(debt.getAllValue());
			record.setCategory(debt.getCategory());
			record.setDate(debt.getDate());
			record.setDescription(debt.getDescription());
			record.setDueDate(debt.getDueDate());
			record.setInstallmentValue(debt.getInstallmentValue());
			record.setName(debt.getName());
			record.setNote(debt.getNote());
			record.setStatus(debt.getStatus());
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

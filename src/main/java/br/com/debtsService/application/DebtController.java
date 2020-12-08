package br.com.debtsService.application;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.debtsService.domain.Debt;
import br.com.debtsService.domain.DebtService;

@RestController
@RequestMapping("/debt")
public class DebtController {
	
	private DebtService service;
	
	
	public DebtController(DebtService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Debt> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Debt findById(@PathVariable Long id) {
		return service.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Debt not found"));
	}
	
	@PostMapping
	public Debt create(@RequestBody @Valid Debt debt) {
		return service.create(debt);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Debt> update(@PathVariable("id") long id, @RequestBody @Valid Debt debt) {
		return service.update(id, debt);
	}
	
	@DeleteMapping(path = { "/{id}" })
	public Optional<?> delete(@PathVariable long id) {
		service.findById(id)
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Debt not found"));
		
		return service.delete(id);
	}
	
}

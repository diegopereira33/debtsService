package br.com.debtsService.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Debt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@NotNull(message = "{name.not.null}")
	private String name; 
	private String description;
	@NotEmpty
	@NotNull(message = "{dueDate.not.null}")
	private String dueDate; 
	@NotEmpty
	@NotNull(message = "{date.not.null}")
	private String date;
	private String note;
	@NotEmpty
	@NotNull(message = "{status.not.null}")
	private String status;
	private String category; 
	
	@NotNull(message = "{allValue.not.null}")
	private int allValue; 
	private int installmentValue;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getAllValue() {
		return allValue;
	}
	public void setAllValue(int allValue) {
		this.allValue = allValue;
	}
	public int getInstallmentValue() {
		return installmentValue;
	}
	public void setInstallmentValue(int installmentValue) {
		this.installmentValue = installmentValue;
	}
	
	
	
	
}

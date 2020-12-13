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
	@NotEmpty
	@NotNull(message = "{dueDate.not.null}")
	private String dueDate; 
	@NotEmpty
	@NotNull(message = "{status.not.null}")
	private String status;
	@NotNull(message = "{value.not.null}")
	private float value; 
	private String description;
	private String payDate;
	private String category; 
	private int parcelNumber;
	
	
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
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
	public int getParcelNumber() {
		return parcelNumber;
	}
	public void setParcelNumber(int parcelNumber) {
		this.parcelNumber = parcelNumber;
	}
	
}

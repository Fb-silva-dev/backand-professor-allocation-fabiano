package com.fabiano.professorallocation.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "professor")
public class Professor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "cpf", length = 11, nullable = false, unique = true)
	private String cpf;

	@Column(name = "department_id", nullable = false)
	private Long departmentId;

	// Criando atributo de navegação
	@ManyToOne(optional = false) // Cardinalidade minima por padrão é true
	@JoinColumn(name = "department_id", nullable = false, insertable = false, updatable = false, referencedColumnName = "id")
	@JsonIgnoreProperties({"professors"})
	private Department department;

	@Column(name = "allocation_id", nullable = true)
	private Long allocationId;

	@ManyToOne(optional = true) // Cardinalidade minima por padrão é true
	@JoinColumn(name = "allocation_id", nullable = false, insertable = false, updatable = false, referencedColumnName = "id")
	private Allocation allocation;

	public Professor() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Long getAllocationId() {
		return allocationId;
	}

	public void setAllocationId(Long allocationId) {
		this.allocationId = allocationId;
	}

	public Allocation getAllocation() {
		return allocation;
	}

	public void setAllocation(Allocation allocation) {
		this.allocation = allocation;
	}

	@Override
	public String toString() {
		return "Professor [id=" + id + ", name=" + name + ", cpf=" + cpf + ", departmentId=" + departmentId
				+ ", department=" + department + ", allocationId=" + allocationId + ", allocation=" + allocation + "]";
	}

}
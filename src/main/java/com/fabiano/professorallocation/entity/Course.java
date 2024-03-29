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
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(name = "name", length = 100, nullable = false)
	private String name;

	@Column(name = "valor", length = 4, nullable = false)
	private Double valor;

	@Column(name = "matricula_id", nullable = true)
	private Long matriculaId;

	// Criando atributo de navegação
	@ManyToOne(optional = true) // Cardinalidade minima por padrão é true
	@JoinColumn(name = "matricula_id", nullable = true, insertable = false, updatable = false, referencedColumnName = "id")
	@JsonIgnoreProperties({"courses"})
	private Matricula matricula;

	@Column(name = "allocation_id",nullable = true)
	private Long allocationId; 
	
	@ManyToOne(optional = false) // Cardinalidade minima por padrão é true
	@JoinColumn(name = "allocation_id", nullable = true, insertable = false, updatable = false, referencedColumnName = "id")
	private Allocation allocation;
	
	public Course() {
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

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Long getMatriculaId() {
		return matriculaId;
	}

	public void setMatriculaId(Long matriculaId) {
		this.matriculaId = matriculaId;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
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
		return "Course [id=" + id + ", name=" + name + ", valor=" + valor + ", matriculaId=" + matriculaId
				+ ", matricula=" + matricula + ", allocationId=" + allocationId + ", allocation=" + allocation + "]";
	}

}

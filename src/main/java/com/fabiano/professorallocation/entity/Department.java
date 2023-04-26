package com.fabiano.professorallocation.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "department")
public class Department {

	@Id
	@Column(nullable = false)
	// Criar um (equivalente) ao auto-incremente
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// Colunm (Usado para alterar as propriedades da coluna
	@Column(name = "name", unique = true, nullable = false)
	private String name;

	@OneToMany(mappedBy = "department")
	List<Professor> professors;

	
	public Department() {
		super();
	}

	public long getId() {
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

	public List<Professor> getProfessors() {
		return professors;
	}

	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", professors=" + professors + "]";
	}
	
	
	
}

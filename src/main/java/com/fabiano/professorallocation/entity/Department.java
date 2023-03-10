package com.fabiano.professorallocation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "department")
public class Department {

	@Id
	@Column(nullable = false)
	// Criar um (equivalente) ao auto-incremente
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	// Colunm (Usado para alterar as propriedades da coluna
	@Column(length = 100, nullable = false)
	private String name;

	public Department() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department [id " + id + ", name =" + name + "]";
	}

}

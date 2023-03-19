package com.fabiano.professorallocation.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
	@Column(length = 100, nullable = false)
	private String name;

	@ManyToOne(optional = false)
	@JoinColumn(name = "matricula_id",nullable = false, insertable = false, updatable = false, referencedColumnName = "id")

	private Matriculado matriculado;
	
	
	public Matriculado getMatriculado() {
		return matriculado;
	}

	public void setMatriculado(Matriculado matriculado) {
		this.matriculado = matriculado;
	}

	@OneToMany(mappedBy = "course")
	List<Matriculado> matriculados;
	
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

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", matriculado=" + matriculado + "]";
	}

}

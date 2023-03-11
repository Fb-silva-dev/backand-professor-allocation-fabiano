package com.fabiano.professorallocation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "matriculado")
public class Matriculado {
	@Id
	@GeneratedValue(strategy   = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 4, nullable = false)
	private int ano;
	
	@Column(length = 4, nullable = false)
	private String semestre;

	private Double valor;
	
	@Column(name = "aluno_id",nullable = false)
	private Long alunomoId;
	
	
	@Column(name = "course_id",nullable = false)
	private Long courseId;

	public Matriculado() {
		super();
	}

	public Long getAlunomoId() {
		return alunomoId;
	}

	public void setAlunomoId(Long alunomoId) {
		this.alunomoId = alunomoId;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Frequenta [alunomoId=" + alunomoId + ", courseId=" + courseId + ", ano=" + ano + ", semestre="
				+ semestre + ", valor=" + valor + "]";
	}

}

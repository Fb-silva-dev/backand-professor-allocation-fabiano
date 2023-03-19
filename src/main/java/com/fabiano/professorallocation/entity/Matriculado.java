package com.fabiano.professorallocation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "matriculado")
public class Matriculado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 4, nullable = false)
	private int ano;

	@Column(length = 4, nullable = false)
	private String semestre;

	private Double valor;

	@Column(name = "aluno_id", nullable = false)
	private Long alunoId;

	@Column(name = "course_id", nullable = false)
	private Long courseId;

	public Matriculado() {
		super();
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "aluno_id", nullable = false, insertable = false, updatable = false)
	private Aluno aluno;

	public Aluno getAlunoId() {
		return aluno;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "course_id", nullable = false, insertable = false, updatable = false)
	private Course course;

	public Course getourseId() {
		return course;
	}

	public void set(Aluno aluno) {
		this.aluno = aluno;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getAlunomoId() {
		return alunoId;
	}

	public void setAlunomoId(Long alunomoId) {
		this.alunoId = alunomoId;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@Override
	public String toString() {
		return "Matriculado [id=" + id + ", ano=" + ano + ", semestre=" + semestre + ", valor=" + valor + ", alunomoId="
				+ alunoId + ", courseId=" + courseId + ", aluno=" + aluno + "]";
	}

}

package com.fabiano.professorallocation.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@Table(name = "matricula")
public class Matricula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @Column(unique = true, nullable = false)
	private Long id;

	@Column(name = "ano", length = 4, nullable = false)
	private int ano;

	@Column(name = "semestre" ,length = 10, nullable = false)
	private String semestre;

	@Column(name = "aluno_id", nullable = false)
	private Long alunoId;

	@Column(name = "course_id", nullable = false)
	private Long courseId;

	@ManyToOne(optional = false)
	@JoinColumn(name = "aluno_id", nullable = false, insertable = false, updatable = false)
	@JsonIgnoreProperties({"alunos"})
	private Aluno aluno;

	@ManyToOne(optional = false)
	@JoinColumn(name = "course_id", nullable = false, insertable = false, updatable = false)
	@JsonIgnoreProperties({"courses"})
	private Course course;

	// Testando essa
	@OneToMany(mappedBy = "matricula")
	private List<Course> courses;

	@OneToMany(mappedBy = "matricula")
	private List<Aluno> alunos;

//-----------------------------------------	
	public Matricula() {
		super();
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

	public Long getAlunoId() {
		return alunoId;
	}

	public void setAlunoId(Long alunoId) {
		this.alunoId = alunoId;
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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Matricula [id=" + id + ", ano=" + ano + ", semestre=" + semestre + ", alunoId=" + alunoId
				+ ", courseId=" + courseId + ", aluno=" + aluno + ", course=" + course + "]";
	}

	/*public static void main(String[] args) {
		Matricula matricula = new Matricula();
		matricula.id = 1L;
		matricula.courses = new ArrayList<Course>();

	} */
}

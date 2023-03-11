package com.fabiano.professorallocation.entity;

import java.time.DayOfWeek;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "allocation")
public class Allocation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, name = "day")
	private DayOfWeek day;

	@Temporal(TemporalType.TIME)
	@Column(name = "inicio", nullable = false)
	private Date inicioHora;
	@Temporal(TemporalType.TIME)
	@Column(name = "fim", nullable = false)
	private Date fimHora;

	@Column(name = "professor_id", nullable = false)
	private Long professorId;

	@ManyToOne(optional = false)
	@JoinColumn(name = "professor_id", nullable = false, insertable = false, updatable = false)
	private Professor professor;

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	@Column(name = "course_id", nullable = false)
	private Long courseId;

	@ManyToOne(optional = false)
	@JoinColumn(name = "course_id", nullable = false, insertable = false, updatable = false)
	private Course course;

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Allocation() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DayOfWeek getDay() {
		return day;
	}

	public void setDay(DayOfWeek day) {
		this.day = day;
	}

	public Date getInicioHora() {
		return inicioHora;
	}

	public void setInicioHora(Date inicioHora) {
		this.inicioHora = inicioHora;
	}

	public Date getFimHora() {
		return fimHora;
	}

	public void setFimHora(Date fimHora) {
		this.fimHora = fimHora;
	}

	public Long getProfessorId() {
		return professorId;
	}

	public void setProfessorId(Long professorId) {
		this.professorId = professorId;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	@Override
	public String toString() {
		return "Allocation [id=" + id + ", day=" + day + ", inicioHora=" + inicioHora + ", fimHora=" + fimHora
				+ ", professorId=" + professorId + ", courseId=" + courseId + "]";
	}

}

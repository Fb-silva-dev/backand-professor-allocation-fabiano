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
	@Column(nullable = false)
	private Date inicioHora;
	@Temporal(TemporalType.TIME)
	@Column(nullable = false)
	private Date fimHora;

	private Long professorId;

	private Long courseId;

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

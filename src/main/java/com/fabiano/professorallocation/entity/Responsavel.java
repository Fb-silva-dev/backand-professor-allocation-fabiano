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
@Table(name = "responsavel")
public class Responsavel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(length = 11, nullable = false, unique = true)
	private String telefone;

	@Column(length = 14, nullable = false, unique = true)
	private String cpf;

	@OneToMany(mappedBy = "responsavel")
	List<Aluno> aluno;

	public Responsavel() {
		super();
	}

	public Long getResponsavel_id() {
		return id;
	}

	public void setResponsavel_id(Long responsavel_id) {
		this.id = responsavel_id;
	}

	public String getName() {
		return name;
	}

	public void setNome(String nome) {
		this.name = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "Responsavel [id=" + id + ", nome=" + name + ", telefone=" + telefone + ", cpf="
				+ cpf + "]";
	}

}

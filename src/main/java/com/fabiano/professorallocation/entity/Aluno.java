package com.fabiano.professorallocation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "aluno")
public class Aluno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(length = 100, nullable = false)
	private String nome;

	@Column(length = 14, nullable = false, unique = true)
	private String cpf;

	@Column(length = 100, nullable = false)
	private String rua;

	@Column(length = 3, nullable = false)
	private Long numero;

	@Column(length = 100, nullable = false)
	private String bairro;

	@Column(length = 9, nullable = false)
	private String cep;

	@Column(length = 2, nullable = false)
	private Long idade;

	public Aluno() {
		super();
	}

	public Long getMatricula() {
		return id;
	}

	public void setMatricula(Long matricula) {
		this.id = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Long getIdade() {
		return idade;
	}

	public void setIdade(Long idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "Aluno [matricula=" + id + ", nome=" + nome + ", cpf=" + cpf + ", rua=" + rua + ", numero=" + numero
				+ ", bairro=" + bairro + ", cep=" + cep + ", idade=" + idade + "]";
	}

}

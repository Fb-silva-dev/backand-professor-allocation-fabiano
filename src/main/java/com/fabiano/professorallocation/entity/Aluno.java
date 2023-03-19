package com.fabiano.professorallocation.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "aluno")
public class Aluno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(length = 100, nullable = false)
	private String name;

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

	@Column(length = 11, nullable = false)
	private Date data_nascimento;

	
	
	public Aluno() {
		super();
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "responsavel_id", nullable = false, insertable = false, updatable = false, referencedColumnName = "id")
	private Responsavel responsavel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return name;
	}

	public void setNome(String nome) {
		this.name = nome;
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

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + name + ", cpf=" + cpf + ", rua=" + rua + ", numero=" + numero
				+ ", bairro=" + bairro + ", cep=" + cep + ", idade=" + idade + ", data_nascimento=" + data_nascimento
				+ ", responsavel=" + responsavel + "]";
	}
	
	

	

}	
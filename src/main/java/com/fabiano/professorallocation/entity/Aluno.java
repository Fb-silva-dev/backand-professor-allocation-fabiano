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
@Table(name = "aluno")
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", length = 100, nullable = false)
	private String name;

	@Column(name = "cpf", length = 14, nullable = false, unique = true)
	private String cpf;

	@Column(name = "rua", length = 100, nullable = false)
	private String rua;

	@Column(name = "numero", length = 3, nullable = false)
	private Long numero;

	@Column(name = "bairro", length = 100, nullable = false)
	private String bairro;

	@Column(name = "cep", length = 8, nullable = false)
	private String cep;

	@Column(name = "idade", length = 2, nullable = false)
	private Long idade;

	@Column(name = "responsavel_id", nullable = true)
	private Long responsavelId;

	@ManyToOne(optional = true)
	@JoinColumn(name = "responsavel_id", nullable = true, insertable = false, updatable = false, referencedColumnName = "id")
	private Responsavel responsavel;

	@Column(name = "matricula_id", nullable = true)
	private Long matriculaId;

	// Criando atributo de navegação
	@ManyToOne(optional = true) // Cardinalidade minima por padrão é true
	@JoinColumn(name = "matricula_id", nullable = true, insertable = false, updatable = false, referencedColumnName = "id")
	private Matricula matricula;

	public Aluno() {
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

	public Long getResponsavelId() {
		return responsavelId;
	}

	public void setResponsavelId(Long responsavelId) {
		this.responsavelId = responsavelId;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

	public Long getMatriculaId() {
		return matriculaId;
	}

	public void setMatriculaId(Long matriculaId) {
		this.matriculaId = matriculaId;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", name=" + name + ", cpf=" + cpf + ", rua=" + rua + ", numero=" + numero
				+ ", bairro=" + bairro + ", cep=" + cep + ", idade=" + idade + ", responsavelId=" + responsavelId
				+ ", responsavel=" + responsavel + ", matriculaId=" + matriculaId + ", matricula=" + matricula + "]";
	}

}
package com.exercise.task.Models;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity	
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;
	@Column
	private String nome;
	@Column
	private String	sobrenome;
	@Embedded
	private String endereco;

	public Usuario(String nome, String sobrenome, String cep, String cidade, String bairro, String logradouro) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cep = cep;
		this.cidade = cidade;
		this.bairro = bairro;
		this.logradouro = logradouro;
	}
	@JsonProperty("cep")
	private String cep;
	
	@JsonProperty("cidade")
	private String cidade;
	
	@JsonProperty("bairro")
	private String bairro;
	
	@JsonProperty("logradouro")
	private String logradouro;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}

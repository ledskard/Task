package com.exercise.task.Models;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity	
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;
	@Column
	private String nome;
	@Column
	private String sobrenome;
	@Embedded
	private Endereco endereco;

	public Usuario(String nome, String sobrenome, String cep, String localidade, String bairro, String logradouro) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.endereco = new Endereco();
		this.endereco.setCep(cep);
		this.endereco.setLocalidade(localidade);
		this.endereco.setBairro(bairro);
		this.endereco.setLogradouro(logradouro);
	}
	public Usuario() {
		
	}
	
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
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}

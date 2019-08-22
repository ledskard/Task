package com.exercise.task.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "Usuario")
public class Usuario {
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;
	@Column
	private String nome;
	@Column
	private String	sobrenome;
	@Column
	private String endereco;
	
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

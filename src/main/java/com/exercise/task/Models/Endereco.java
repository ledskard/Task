package com.exercise.task.Models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import com.fasterxml.jackson.annotation.JsonProperty;

@Embeddable
public class Endereco {
	@Column(name= "cep", updatable = false, insertable = false)
	@JsonProperty("cep")
	private String cep;
	@Column(name= "cidade", updatable = false, insertable = false)
	@JsonProperty("cidade")
	private String cidade;
	@Column(name= "bairro", updatable = false, insertable = false)
	@JsonProperty("bairro")
	private String bairro;
	@Column(name= "logradouro", updatable = false, insertable = false)
	@JsonProperty("logradouro")
	private String logradouro;
	

	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

}

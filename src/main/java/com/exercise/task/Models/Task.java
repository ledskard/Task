
package com.exercise.task.Models;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task")
public class Task {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;	
	@Column(name= "usuario_id")
	private Long usuario;
	private String taskNome;
	private String descricao;
	private String status;
	
	public Long getUsuario() {
		return usuario;
	}	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTaskNome() {
		return taskNome;
	}
	public void setTaskNome(String taskNome) {	
		this.taskNome = taskNome;
	}
}


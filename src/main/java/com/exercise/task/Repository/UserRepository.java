package com.exercise.task.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercise.task.Models.Usuario;


public interface UserRepository extends JpaRepository<Usuario, Long>{
	public Optional<Usuario> findByUser(String usuario);
	public Optional<Usuario> deleteByUser(String usuario);
}

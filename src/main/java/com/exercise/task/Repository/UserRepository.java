package com.exercise.task.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exercise.task.Models.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long>{
	public Optional<Usuario> findByNome(String nome);
}

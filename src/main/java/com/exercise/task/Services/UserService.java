package com.exercise.task.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.task.Models.Usuario;
import com.exercise.task.Repository.UserRepository;



@Service
public class UserService {
	
	
	@Autowired
	private UserRepository userRepository;

	
	
	// GET
	public Usuario searchById(Long id) {
		Optional<Usuario> buscaPorId = userRepository.findById(id);
		return buscaPorId.get();
		
	}
	//GET
	public List<Usuario> searchAll() {
		return userRepository.findAll();
	}
	//GET
	public Usuario searchByUser(String usuario) {
		Optional<Usuario> buscaPorUsuario = userRepository.findByUser(usuario);
		return buscaPorUsuario.get();	
	}
	//POST
	public void saveUser(Usuario usuario) {
		userRepository.save(usuario);
	}
	//PUT
	public void updateUser(String usuario, Usuario newUsuario) {
		Usuario savedUser = userRepository.findByUser(usuario).get();
		BeanUtils.copyProperties(newUsuario, savedUser, "id");
		userRepository.save(savedUser);
	}
	//delete
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}
	//delete
	public void DeleteByUser(String usuario) {
		userRepository.deleteByUser(usuario);
	}
}

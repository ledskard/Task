
package com.exercise.task.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.task.Feign.FeignConfiguration;
import com.exercise.task.Models.Usuario;
import com.exercise.task.Repository.UserRepository;
import com.exercise.task.dto.UserDTO;
import com.exercise.task.dto.response.CepResponse;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private FeignConfiguration feignConfiguration;
	
	
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
	public Usuario searchByName(String nome) {
		Optional<Usuario> buscaPorUsuario = userRepository.findByNome(nome);
		return buscaPorUsuario.get();	
	}
	//POST
	public void saveUser(UserDTO usuario) {
		CepResponse getCep = feignConfiguration.validaCep(usuario.getCep());
		Usuario newUsuario = new Usuario(usuario.getNome(), usuario.getSobrenome(), getCep.getCep(), getCep.getLocalidade(), getCep.getBairro(), getCep.getLogradouro());
		userRepository.save(newUsuario);
	}
	//PUT
	public void updateUser(String nome, Usuario newNome) {
		Usuario savedNome = userRepository.findByNome(nome).get();
		BeanUtils.copyProperties(newNome, savedNome, "id");
		userRepository.save(savedNome);
	}
	//delete
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}
}

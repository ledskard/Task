package com.exercise.task.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.task.Models.Usuario;
import com.exercise.task.Services.UserService;
import com.exercise.task.dto.UserDTO;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/user/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable("id") Long id){
		Usuario buscaPorId = userService.searchById(id);
		return ResponseEntity.ok(buscaPorId);
	}
	@GetMapping("/user")
	public ResponseEntity<List<Usuario>> getAll(){
		List<Usuario> buscarTodos = userService.searchAll();
		return ResponseEntity.ok(buscarTodos);
	}
	@GetMapping("/user/buscanome/{nome}")
	public ResponseEntity<Usuario> getByName(@PathVariable("nome")String nome){ 
		Usuario buscaUsuario = userService.searchByName(nome);
		return buscaUsuario != null ? ResponseEntity.ok(buscaUsuario) : ResponseEntity.notFound().build(); 
	}
	@PostMapping("/user")
	public ResponseEntity<String> addUser(@RequestBody UserDTO usuario){
		userService.saveUser(usuario);
		return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("CRIADO");
	}
	@PutMapping("/user/{usuario}")
	public ResponseEntity<String> updateUser(@RequestBody Usuario newUsuario, @PathVariable("usuario") String usuario){
		userService.updateUser(usuario, newUsuario);
		return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("CRIADO");
	}
	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") Long id){
		userService.deleteById(id);
		return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("DELETADO");
	}
	
}
package com.projeto_integrador_4.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto_integrador_4.dao.UsuarioRepository;
import com.projeto_integrador_4.models.Usuario;

@RestController
@RequestMapping({"/usuario"})
public class UsuarioController {
	
	private UsuarioRepository repository;
	
	public UsuarioController(UsuarioRepository usuarioRepository) {
		this.repository = usuarioRepository;
	}
	
	@GetMapping
	public List findAll() {
		return repository.findAll();
	}
	
	@PostMapping
	public Usuario create(@RequestBody Usuario usuario) {
		return repository.save(usuario);
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity findById(@PathVariable long id) {
		return repository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity update(@PathVariable("id") long id, @RequestBody Usuario usuario) {
		return repository.findById(id)
				.map(record -> {
					record.setLogin(usuario.getLogin());
					record.setEmail(usuario.getEmail());
					record.setRenda(usuario.getRenda());
					record.setTelefone(usuario.getTelefone());
					record.setSenha(usuario.getSenha());
					Usuario atualizado = repository.save(record);
					return ResponseEntity.ok().body(atualizado);
				}).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path = {"/{id}"})
	public ResponseEntity delete(@PathVariable long id) {
		return repository.findById(id)
				.map(record -> {
					repository.deleteById(id);
					return ResponseEntity.ok().build();
				}).orElse(ResponseEntity.notFound().build());
	}
	
}

package com.projeto_integrador_4.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto_integrador_4.dao.LancamentosUsuarioRepository;
import com.projeto_integrador_4.models.LancamentosUsuario;

@RestController
@RequestMapping({"/usuario/lancamentos"})
public class LancamentosUsuarioController {
	
	private LancamentosUsuarioRepository repository;
	
	public LancamentosUsuarioController(LancamentosUsuarioRepository lancamentosUsuarioRepository) {
		this.repository = lancamentosUsuarioRepository;
	}
	
	@GetMapping
	public List findAll() {
		return repository.findAll();
	}
	
	@PostMapping
	public LancamentosUsuario create(@RequestBody LancamentosUsuario lancamentosUsuario) {
		return repository.save(lancamentosUsuario);
	}
}

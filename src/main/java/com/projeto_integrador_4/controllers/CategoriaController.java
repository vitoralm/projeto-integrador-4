package com.projeto_integrador_4.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto_integrador_4.dao.CategoriaRepository;
import com.projeto_integrador_4.models.Categoria;

@RestController
@RequestMapping({"/categoria"})
public class CategoriaController {
	
	private CategoriaRepository repository;
	
	CategoriaController(CategoriaRepository categoriaRepository) {
		this.repository = categoriaRepository;
	}
	
	@GetMapping
	public List findAll() {
		return repository.findAll();
	}
	
	@PostMapping
	public Categoria create(@RequestBody Categoria categoria) {
		return repository.save(categoria);
	}
}

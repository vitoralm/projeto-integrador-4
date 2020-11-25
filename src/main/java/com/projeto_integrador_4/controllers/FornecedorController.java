package com.projeto_integrador_4.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto_integrador_4.dao.FornecedorRepository;
import com.projeto_integrador_4.models.Fornecedor;

@RestController
@RequestMapping({"/fornecedor"})
public class FornecedorController {

	private FornecedorRepository repository;
	
	FornecedorController(FornecedorRepository fornecedorRepository) {
		this.repository = fornecedorRepository;
	}
	
	@GetMapping
	public List findAll() {
		return repository.findAll();
	}
	
	@PostMapping
	public Fornecedor create(@RequestBody Fornecedor fornecedor) {
		return repository.save(fornecedor);
	}
}

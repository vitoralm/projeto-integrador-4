package com.projeto_integrador_4.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto_integrador_4.dao.LancamentoRepository;
import com.projeto_integrador_4.models.Lancamento;

@RestController
@RequestMapping({"/lancamento"})
public class LancamentoController {

	private LancamentoRepository repository;
	
	LancamentoController (LancamentoRepository lancamentoRepository) {
		this.repository = lancamentoRepository;
	}
	
	@GetMapping
	public List findAll() {
		return repository.findAll();
	}
	
	@PostMapping
	public Lancamento create(@RequestBody Lancamento lancamento) {
		return repository.save(lancamento);
	}
	
}

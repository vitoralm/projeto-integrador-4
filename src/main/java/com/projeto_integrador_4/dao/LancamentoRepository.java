package com.projeto_integrador_4.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto_integrador_4.models.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
	
}

package com.projeto_integrador_4.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto_integrador_4.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
}

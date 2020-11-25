package com.projeto_integrador_4.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projeto_integrador_4.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	@Query(value = "select * from usuario where login = ?1", nativeQuery = true)
	public Optional<Usuario> findByLogin(String login);
}

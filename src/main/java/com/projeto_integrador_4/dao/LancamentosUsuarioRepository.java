package com.projeto_integrador_4.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projeto_integrador_4.models.LancamentosUsuario;
import com.projeto_integrador_4.models.Usuario;

public interface LancamentosUsuarioRepository extends JpaRepository<LancamentosUsuario, Long> {
	/*@Query(value = "select * from lancamentos_usuario where idusuario = ?1", nativeQuery = true)
	public List<LancamentosUsuario> findByUsuario(Usuario usuario);*/	
}

package com.projeto_integrador_4;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.projeto_integrador_4.dao.UsuarioRepository;
import com.projeto_integrador_4.models.Usuario;

@SpringBootTest
class ProjetoIntegrador4ApplicationTests {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Test
	void test() {
		
		Usuario test = new Usuario();
		test.setLogin("test_login");
		test.setSenha("test_senha");
		test.setEmail("test@test.com");
		test.setRenda((float) 9999);
		test.setTelefone("99999999");
		repository.save(test);
		Usuario found = repository.findByLogin(test.getLogin()).get();
		assertThat(found.getLogin().equals(test.getLogin()));
		
		Long id = found.getId();
		
		repository.findById(id).map(record -> {
			repository.deleteById(id);
			return "ok";
		}).orElse("ok");
		
	}

}

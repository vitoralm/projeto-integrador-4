package com.projeto_integrador_4.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "usuario")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class Usuario {
	
	@Id
	@GeneratedValue
	private Long id;
	private String login;
	private String senha;
	private String email;
	private String telefone;
	private Float renda;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<LancamentosUsuario> lancamentosUsuario;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Categoria> categoriasUsuario;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Fornecedor> fornecedoresUsuario;
}

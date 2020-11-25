package com.projeto_integrador_4.models;


import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "lancamento")
public class Lancamento {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String tipo;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	
	private Float valor;
	private String descricao;
	
	@OneToMany(mappedBy = "lancamento", cascade = CascadeType.ALL)
	private List<LancamentosUsuario> lancamentosUsuario;
	
}

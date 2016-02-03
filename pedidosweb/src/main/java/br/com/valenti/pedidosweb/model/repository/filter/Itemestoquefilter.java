package br.com.valenti.pedidosweb.model.repository.filter;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.valenti.pedidosweb.model.def.Empresa;
import br.com.valenti.pedidosweb.model.def.Produto;
import br.com.valenti.pedidosweb.security.Seguranca;

public class Itemestoquefilter implements Serializable {

	/************************************** PROPRIEDADES ********************************************/
	private static final long serialVersionUID = 1L;
	
	private String nome; // pesquisar por nome

	private Empresa empresa;
	
	@Inject
	private Seguranca seguranca;

	/************************************** CONSTRUTOR ********************************************/

	/************************************** GETS ********************************************/

	public String getNome() {
		return nome;
	}	
	
	public Empresa getEmpresa() {
		return empresa;
	}
	
	public Seguranca getSeguranca() {
		return seguranca;
	}	
	
	/************************************** SETS ********************************************/
	public void setNome(String nome) {
		this.nome = nome;
	}	
	
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}	

	public void setSeguranca(Seguranca seguranca) {
		this.seguranca = seguranca;
	}

	/************************************** MÉTODOS ********************************************/
	
	
	/************************************** hashCode E equals ********************************************/

}

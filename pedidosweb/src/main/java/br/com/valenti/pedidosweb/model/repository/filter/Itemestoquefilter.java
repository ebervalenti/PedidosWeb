package br.com.valenti.pedidosweb.model.repository.filter;

import java.io.Serializable;

import br.com.valenti.pedidosweb.model.def.Produto;

public class Itemestoquefilter implements Serializable {

	/************************************** PROPRIEDADES ********************************************/
	private static final long serialVersionUID = 1L;
	
	private String nome; // pesquisar por nome	

	/************************************** CONSTRUTOR ********************************************/

	/************************************** GETS ********************************************/

	public String getNome() {
		return nome;
	}	
	
	/************************************** SETS ********************************************/
	public void setNome(String nome) {
		this.nome = nome;
	}		

	/************************************** MÉTODOS ********************************************/
	
	
	/************************************** hashCode E equals ********************************************/

}

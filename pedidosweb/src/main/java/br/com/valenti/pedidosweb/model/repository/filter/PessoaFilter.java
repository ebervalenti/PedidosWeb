/**
 * 
 */
package br.com.valenti.pedidosweb.model.repository.filter;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.valenti.pedidosweb.model.def.Empresa;
import br.com.valenti.pedidosweb.security.Seguranca;
import br.com.valenti.pedidosweb.validation.SKU;

/**  Criado por: Eber Lasso  **/

public class PessoaFilter implements Serializable {

	/************************************** PROPRIEDADES ********************************************/
	private static final long serialVersionUID = 1L;
	
	private String nome; // pesquisar por nome
	
	private Long id; 
	
	//TODO implementar o restante de pesquuisas de pessoas
	
	private Empresa empresa;
	
	@Inject
	private Seguranca seguranca;

	/************************************** CONSTRUTOR ********************************************/

	/************************************** GETS ********************************************/
	public String getNome() {
		return nome;
	}	
	
	public Long getId() {
		return id;
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}
	
	public Seguranca getSeguranca() {
		return seguranca;
	}


	/************************************** SETS ********************************************/
	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
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

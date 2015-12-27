/**
 * 
 */
package br.com.valenti.pedidosweb.model.repository.filter;

import java.io.Serializable;

import br.com.valenti.pedidosweb.validation.SKU;

/**  Criado por: Eber Lasso  **/

public class PessoaFilter implements Serializable {

	/************************************** PROPRIEDADES ********************************************/
	private static final long serialVersionUID = 1L;
	
	private String nome; // pesquisar por nome
	
	private Long id; 
	
	//TODO implementar o restante de pesquuisas de pessoas

	/************************************** CONSTRUTOR ********************************************/

	/************************************** GETS ********************************************/
	public String getNome() {
		return nome;
	}	
	
	public Long getId() {
		return id;
	}


	/************************************** SETS ********************************************/
	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}		
		
	/************************************** MÉTODOS ********************************************/

	/************************************** hashCode E equals ********************************************/

}

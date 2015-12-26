/**
 * 
 */
package br.com.valenti.pedidosweb.model.repository.filter;

import java.io.Serializable;

import br.com.valenti.pedidosweb.validation.SKU;

/**  Criado por: Eber Lasso  **/

public class ProdutoFilter implements Serializable {

	/************************************** PROPRIEDADES ********************************************/
	private static final long serialVersionUID = 1L;
	
	private String nome; // pesquisar por nome
	
	@SKU
	private String sku; // pesquisar por sku
	

	/************************************** CONSTRUTOR ********************************************/

	/************************************** GETS ********************************************/
		public String getNome() {
			return nome;
		}
	
		public String getSku() {
			return sku;
		}
	/************************************** SETS ********************************************/

		public void setNome(String nome) {
			this.nome = nome;
		}

		public void setSku(String sku) {
			if (sku == null) {
				this.sku = null;
				
			} else {
				this.sku = sku.toUpperCase();
			}		
		}
		
	/************************************** MÉTODOS ********************************************/

	/************************************** hashCode E equals ********************************************/

}

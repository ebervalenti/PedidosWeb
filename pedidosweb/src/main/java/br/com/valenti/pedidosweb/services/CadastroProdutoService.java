/**
 * 
 */
package br.com.valenti.pedidosweb.services;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.valenti.pedidosweb.model.def.Produto;
import br.com.valenti.pedidosweb.model.repository.Produtos;
import br.com.valenti.pedidosweb.util.jpa.Transacional;

/**  Criado por: Eber Lasso  **/

public class CadastroProdutoService implements Serializable {
	/************************************** PROPRIEDADES ********************************************/
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Produtos produtos;
	/************************************** CONSTRUTOR ********************************************/

	/************************************** GETS ********************************************/

	/************************************** SETS ********************************************/

	/************************************** MÉTODOS ********************************************/
	@Transacional /* interceptador para criar a transação - se este método executar sem erros 
	 					essa anotação fará o commit se não fará o rollback */ 
	public Produto salvar(Produto produto){
		 Produto produtoExistente = produtos.porId(produto.getId());
		 
		 if (produtoExistente != null && !produtoExistente.equals(produto)){
			 
			 throw new NegocioException("Já existe um produto com o SKU informado!");
			
		}
		return produtos.guardar(produto);
		 
	 }
	/************************************** hashCode E equals ********************************************/

}

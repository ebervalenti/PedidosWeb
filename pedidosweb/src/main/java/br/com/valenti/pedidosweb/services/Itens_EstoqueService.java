
package br.com.valenti.pedidosweb.services;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.valenti.pedidosweb.model.def.ItemEstoque;
import br.com.valenti.pedidosweb.model.repository.Itens_Estoque;
import br.com.valenti.pedidosweb.util.jpa.Transacional;

public class Itens_EstoqueService implements Serializable{

	private static final long serialVersionUID = 1L;
	/************************************** PROPRIEDADES ********************************************/
	@Inject
	private Itens_Estoque itensEstoque;
	/************************************** CONSTRUTOR ********************************************/

	/************************************** GETS ********************************************/

	/************************************** SETS ********************************************/

	/************************************** MÉTODOS ********************************************/
	@Transacional
	public ItemEstoque guardar(ItemEstoque item){
		return itensEstoque.guardar(item);
	}
	/************************************** hashCode E equals ********************************************/

}

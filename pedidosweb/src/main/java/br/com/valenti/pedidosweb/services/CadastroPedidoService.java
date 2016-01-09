/**
 * 
 */
package br.com.valenti.pedidosweb.services;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import br.com.valenti.pedidosweb.model.def.Pedido;
import br.com.valenti.pedidosweb.model.enumeration.StatusPedido;
import br.com.valenti.pedidosweb.model.repository.Pedidos;
import br.com.valenti.pedidosweb.util.jpa.Transacional;

/**  Criado por: Eber Lasso  **/

public class CadastroPedidoService implements Serializable {	
	/************************************** PROPRIEDADES ********************************************/
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Pedidos pedidos;	

	/************************************** CONSTRUTOR ********************************************/

	/************************************** GETS ********************************************/

	/************************************** SETS ********************************************/

	/************************************** MÉTODOS ********************************************/
	@Transacional
	public Pedido salvar(Pedido pedido){
		if (pedido.isNovo()) {			
			pedido.setDataCriacao(new Date());			
			pedido.setStatus(StatusPedido.ORCAMENTO);			
		}	
		
		if (pedido.getItensPedidos().isEmpty()) {
			throw new NegocioException("Não é possivel salvar pedido sem itens.");
		}
		
		if (pedido.isValorNegativo()) {
			throw new NegocioException("Total do pedido inconcistente. ");			
		}
		
		if (pedido.isNaoAlteravel()) {
			throw new NegocioException("Pedido já " + pedido.getStatus().getDescricao().toUpperCase() + 
					" não pode ser alterado." );
		}
		
		pedido.recalcularValorTotal();		
		pedido = this.pedidos.guardar(pedido);
		return pedido;		
	}
}

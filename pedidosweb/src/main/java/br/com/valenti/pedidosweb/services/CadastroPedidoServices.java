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

public class CadastroPedidoServices implements Serializable {	
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
			System.out.println("if (pedido.isNovo())");
			pedido.setDataCriacao(new Date());			
			pedido.setStatus(StatusPedido.ORCAMENTO);			
		}
		pedido = this.pedidos.guardar(pedido);
		return pedido;
		
	}

	

}

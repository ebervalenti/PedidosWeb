package br.com.valenti.pedidosweb.controller.events;

import br.com.valenti.pedidosweb.model.def.Pedido;

public class PedidoAlteradoEvent {
	/************************************** PROPRIEDADES ********************************************/
	private Pedido pedido; 

	/************************************** CONSTRUTOR ********************************************/
	public PedidoAlteradoEvent(Pedido pedido) {
		this.pedido = pedido; 		
	}


	/************************************** GETS ********************************************/
	public Pedido getPedido() {
		return pedido;
	}

	/************************************** SETS ********************************************/

	/************************************** MÉTODOS ********************************************/

	/************************************** hashCode E equals ********************************************/

}

package br.com.valenti.pedidosweb.services;

import java.io.Serializable;
import java.util.Iterator;

import javax.inject.Inject;

import br.com.valenti.pedidosweb.model.def.ItemPedido;
import br.com.valenti.pedidosweb.model.def.Pedido;
import br.com.valenti.pedidosweb.model.repository.Pedidos;
import br.com.valenti.pedidosweb.util.jpa.Transacional;

public class EstoqueService implements Serializable {

	/************************************** PROPRIEDADES ********************************************/
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Pedidos pedidos;

	/************************************** CONSTRUTOR ********************************************/

	/************************************** GETS ********************************************/

	/************************************** SETS ********************************************/

	/************************************** MÉTODOS ********************************************/
	
	@Transacional
	public void baixarItensEstoque(Pedido pedido){
		pedido = this.pedidos.porId(pedido.getId());
		
		for (ItemPedido	 item: pedido.getItensPedidos()) {
			item.getProduto().baixarEstoque(item.getQuantidade());
		}	
	}
	

	public void retornarItensEstoque(Pedido pedido) {
		pedido = this.pedidos.porId(pedido.getId());
		
		for (ItemPedido item : pedido.getItensPedidos()) {
			item.getProduto().adicionarEstoque(item.getQuantidade());
		}	
	}

	public void incrementaQtdTotalProduto(Pedido pedido) {		
		retornarItensEstoque(pedido);
	}

	/************************************** hashCode E equals ********************************************/

}

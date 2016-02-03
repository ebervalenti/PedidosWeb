package br.com.valenti.pedidosweb.services;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.valenti.pedidosweb.model.def.Pedido;
import br.com.valenti.pedidosweb.model.enumeration.StatusPedido;
import br.com.valenti.pedidosweb.model.repository.Pedidos;
import br.com.valenti.pedidosweb.util.jpa.Transacional;

public class CancelamentoPedidoService implements Serializable {

	/************************************** PROPRIEDADES ********************************************/
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Pedidos pedidos;
	
	@Inject
	private Itens_EstoqueService itensEstoqueService;

	/************************************** CONSTRUTOR ********************************************/

	/************************************** GETS ********************************************/

	/************************************** SETS ********************************************/

	/************************************** MÉTODOS ********************************************/
	@Transacional
	public Pedido cancelar(Pedido pedido) {
		pedido = this.pedidos.porId(pedido.getId());
		
		if (pedido.isNaoCancelavel()) {
			throw new NegocioException("Não é possível o cancelamento de pedido já " +  
					pedido.getStatus().getDescricao().toUpperCase()+".");
		}
		
		if (pedido.isEmitido()) {
			this.itensEstoqueService.incrementaQtdTotalProduto(pedido);
		}
		
		pedido.setStatus(StatusPedido.CANCELAD0);
		
		pedido = this.pedidos.guardar(pedido);
		
		return pedido;
	}
	
	/************************************** hashCode E equals ********************************************/

}

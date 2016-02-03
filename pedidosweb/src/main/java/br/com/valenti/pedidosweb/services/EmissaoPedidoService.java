package br.com.valenti.pedidosweb.services;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.valenti.pedidosweb.model.def.Pedido;
import br.com.valenti.pedidosweb.model.enumeration.Operacao;
import br.com.valenti.pedidosweb.model.enumeration.StatusPedido;
import br.com.valenti.pedidosweb.model.repository.Pedidos;
import br.com.valenti.pedidosweb.util.jpa.Transacional;

public class EmissaoPedidoService implements Serializable{

	/************************************** PROPRIEDADES ********************************************/
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroPedidoService cadastroPedidoService;
	
	@Inject
	private Pedidos pedidos;
	
	@Inject
	private Itens_EstoqueService itensEstoqueService;
	
	private Operacao opoeracao;
	

	/************************************** CONSTRUTOR ********************************************/

	/************************************** GETS ********************************************/

	/************************************** SETS ********************************************/

	/************************************** MÉTODOS ********************************************/
	@Transacional
	public Pedido emitir(Pedido pedido){
		 pedido = this.cadastroPedidoService.salvar(pedido);
		 
		 if (pedido.isNaoEmissivel()) {
			throw new NegocioException("Não é possível a emissão de pedido já " + 
					pedido.getStatus().getDescricao().toUpperCase() +".");
		}			 
		 
		 this.itensEstoqueService.atualizaQtdItensEstoque(pedido,opoeracao.ENTRADA );
		 
		 pedido.setStatus(StatusPedido.EMITIDO);
		 
		 pedido = this.pedidos.guardar(pedido);
		 
		 return pedido;		
	}

	/************************************** hashCode E equals ********************************************/

}

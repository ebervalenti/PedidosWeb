
package br.com.valenti.pedidosweb.services;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import br.com.valenti.pedidosweb.model.def.ItemEstoque;
import br.com.valenti.pedidosweb.model.def.ItemPedido;
import br.com.valenti.pedidosweb.model.def.Pedido;
import br.com.valenti.pedidosweb.model.enumeration.StatusPedido;
import br.com.valenti.pedidosweb.model.repository.Itens_Estoque;
import br.com.valenti.pedidosweb.model.repository.Pedidos;
import br.com.valenti.pedidosweb.util.jpa.Transacional;

public class Itens_EstoqueService implements Serializable{

	private static final long serialVersionUID = 1L;
	/************************************** PROPRIEDADES ********************************************/
	@Inject
	private Itens_Estoque itensEstoque;
	
	@Inject
	private Pedidos pedidos;
	
	/************************************** CONSTRUTOR ********************************************/

	/************************************** GETS ********************************************/

	/************************************** SETS ********************************************/

	/************************************** MÉTODOS ********************************************/
	@Transacional
	public ItemEstoque guardar(ItemEstoque item){
		return itensEstoque.salvar(item);
	}
	
	
	@Transacional
	public Pedido guardarPedido(Pedido pedido) {
		
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

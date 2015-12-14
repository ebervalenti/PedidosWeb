package br.com.valenti.pedidosweb.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.valenti.pedidosweb.model.def.EnderecoEntrega;
import br.com.valenti.pedidosweb.model.def.Pedido;
import br.com.valenti.pedidosweb.services.NegocioException;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;


@Named
@ViewScoped
public class CadastroPedidoBean implements Serializable{
	
	/************************************** PROPRIEDADES ********************************************/	
    
    private static final long serialVersionUID = 1L;
    
    private Pedido pedido;

	private List<Integer> itens;
	
	/************************************** CONSTRUTOR ********************************************/
	
	public CadastroPedidoBean() {
		pedido = new Pedido();
		pedido.setEnderecoEntrega(new EnderecoEntrega());
		itens = new ArrayList();
		itens.add(1);
	}
	
	/************************************** GETS E SETS ********************************************/
	
	public List<Integer> getItens() {
		return itens;
	}	
		
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	/************************************** MÉTODOS ********************************************/
	
	public void salvar() {
		throw new NegocioException("Pedido não pode ser salvo, pois ainda não foi implementado.");
	}

	
	
}
package br.com.valenti.pedidosweb.controller.pedido;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.valenti.pedidosweb.model.def.Pedido;
import br.com.valenti.pedidosweb.model.enumeration.StatusPedido;
import br.com.valenti.pedidosweb.model.repository.Pedidos;
import br.com.valenti.pedidosweb.model.repository.filter.PedidosFilter;
import br.com.valenti.pedidosweb.security.Seguranca;

@Named
@ViewScoped
public class PesquisaPedidosBean implements Serializable {
	
	/************************************** PROPRIEDADES ********************************************/
	private static final long serialVersionUID = 1L;
	
	private List<Pedido> pedidosFiltrados;
	
	private PedidosFilter filtro;
	
	@Inject
	Pedidos pedidos;
	
	@Inject
	private Seguranca seguranca;		

	/************************************** CONSTRUTOR ********************************************/
	public PesquisaPedidosBean() {		
		filtro = new PedidosFilter();
		pedidosFiltrados = new ArrayList<>();
		
		}
	/************************************** GETS ********************************************/

	public List<Pedido> getPedidosFiltrados() {
		return pedidosFiltrados;
	}	
	
	public PedidosFilter getFiltro() {
		return filtro;
	}
	/************************************** SETS ********************************************/
	public void setPedidosFiltrados(List<Pedido> pedidosFiltrados) {
		this.pedidosFiltrados = pedidosFiltrados;
	}

	public void setFiltro(PedidosFilter filtro) {
		this.filtro = filtro;
	}
	/************************************** MÉTODOS ********************************************/
	public void pesquisar(){		
		filtro.setEmpresa(seguranca.getUsuario().getEmpresa());		
		pedidosFiltrados = pedidos.filtrados(filtro);
	}
	
	public StatusPedido[] getStatusPedidos(){
		return StatusPedido.values();
	}
	
		

}

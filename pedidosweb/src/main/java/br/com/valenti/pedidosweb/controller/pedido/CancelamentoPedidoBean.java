package br.com.valenti.pedidosweb.controller.pedido;

import java.io.Serializable;

import javax.enterprise.event.Event;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.valenti.pedidosweb.controller.events.PedidoAlteradoEvent;
import br.com.valenti.pedidosweb.model.def.Pedido;
import br.com.valenti.pedidosweb.services.CancelamentoPedidoService;
import br.com.valenti.pedidosweb.util.jpa.Transacional;
import br.com.valenti.pedidosweb.util.jsf.FacesUtil;

@Named
@RequestScoped
public class CancelamentoPedidoBean implements Serializable {

	/************************************** PROPRIEDADES ********************************************/
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CancelamentoPedidoService cancelamentoPedioService;
	
	@Inject
	private Event<PedidoAlteradoEvent> pedidoAlteradoEvent;
	
	@Inject
	@PedidoEdicao
	private Pedido pedido;

	/************************************** CONSTRUTOR ********************************************/

	/************************************** GETS ********************************************/

	/************************************** SETS ********************************************/

	/************************************** MÉTODOS ********************************************/
	@Transacional
	public  void cancelarPedido(){
		this.pedido = this.cancelamentoPedioService.cancelar(pedido);
		this.pedidoAlteradoEvent.fire(new PedidoAlteradoEvent(pedido));
		
		FacesUtil.addInfoMessage("Pedido cancelado com sucesso!");
			
		}
	/************************************** hashCode E equals ********************************************/

}

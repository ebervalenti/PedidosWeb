package br.com.valenti.pedidosweb.controller.pedido;

import java.io.Serializable;

import javax.enterprise.event.Event;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.valenti.pedidosweb.controller.events.PedidoAlteradoEvent;
import br.com.valenti.pedidosweb.model.def.Pedido;
import br.com.valenti.pedidosweb.services.EmissaoPedidoService;
import br.com.valenti.pedidosweb.util.jsf.FacesUtil;

@Named
@RequestScoped
public class EmissaoPedidoBean implements Serializable {

	/************************************** PROPRIEDADES ********************************************/
	private static final long serialVersionUID = 1L;
	
	@Inject
	@PedidoEdicao
	private Pedido pedido;
	
	@Inject
	private EmissaoPedidoService emissaoPedidoService;
	
	@Inject
	private Event<PedidoAlteradoEvent> pedidoAlteradoEvent;

	/************************************** CONSTRUTOR ********************************************/

	/************************************** GETS ********************************************/

	/************************************** SETS ********************************************/

	/************************************** MÉTODOS ********************************************/
	public void emitirPedido(){
		this.pedido.removerItemVazio();
		
		try {
			this.pedido = this.emissaoPedidoService.emitir(this.pedido);
			this.pedidoAlteradoEvent.fire(new PedidoAlteradoEvent(this.pedido));
			
			FacesUtil.addInfoMessage("Pedido: "+ this.pedido.getId()+" para "+ this.pedido.getCliente().getNome() +
					" emitido com sucesso");
			
		} finally {
			this.pedido.adicionarItemVazio();
		}
	}

	/************************************** hashCode E equals ********************************************/

}

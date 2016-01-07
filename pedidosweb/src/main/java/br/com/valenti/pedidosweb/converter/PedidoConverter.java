package br.com.valenti.pedidosweb.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.valenti.pedidosweb.model.def.Pedido;
import br.com.valenti.pedidosweb.model.repository.Pedidos;
import br.com.valenti.pedidosweb.util.cdi.CDIServiceLocator;

/**  Criado por: Eber Lasso  **/

@FacesConverter(forClass = Pedido.class)
public class PedidoConverter implements Converter {
	/************************************** PROPRIEDADES ********************************************/
	
	//@Inject
	private Pedidos pedidos;
	

	/************************************** CONSTRUTOR ********************************************/
	
	public PedidoConverter() {		
		this.pedidos = CDIServiceLocator.getBean(Pedidos.class);
	}
	

	/************************************** GETS ********************************************/
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Pedido retorno = null;
		
		if (value != null) {
			Long id = new Long(value);
			return pedidos.porId(id) ;			
		}
		return retorno;
		
	}	

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Pedido pedido = (Pedido) value;
			if (pedido.getId() == null) {				
				return  null;
			}
			else{				
				return pedido.getId().toString();		
			}
		}
		return "";
	}

	/************************************** SETS ********************************************/

	/************************************** MÉTODOS ********************************************/

	/************************************** hashCode E equals ********************************************/
}



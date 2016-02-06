package br.com.valenti.pedidosweb.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.valenti.pedidosweb.model.def.Cliente;
import br.com.valenti.pedidosweb.model.def.Pedido;
import br.com.valenti.pedidosweb.model.repository.Clientes;
import br.com.valenti.pedidosweb.util.cdi.CDIServiceLocator;

/**  Criado por: Eber Lasso  **/

@FacesConverter(forClass = Cliente.class)
public class ClienteConverter implements Converter {
	/************************************** PROPRIEDADES ********************************************/
	
	//@Inject
	private Clientes clientes;
	

	/************************************** CONSTRUTOR ********************************************/
	
	public ClienteConverter() {		
		this.clientes = (Clientes) CDIServiceLocator.getBean(Clientes.class);
	}
	

	/************************************** GETS ********************************************/	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Cliente retorno = null;
		
		if (value != null) {			
			retorno =  this.clientes.porId(new Long(value)) ;			
		}
		return retorno;	
	}	
		

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Cliente cliente = (Cliente) value;
			if (cliente.getId() == null) {
				return null;				
			}
			else
			{
				return cliente.getId().toString();
			}
		}
		return "";	
	}

	/************************************** SETS ********************************************/

	/************************************** MÉTODOS ********************************************/

	/************************************** hashCode E equals ********************************************/

}

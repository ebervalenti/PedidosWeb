package br.com.valenti.pedidosweb.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.valenti.pedidosweb.model.def.Pessoa;
import br.com.valenti.pedidosweb.model.def.Usuario;
import br.com.valenti.pedidosweb.model.repository.Usuarios;
import br.com.valenti.pedidosweb.util.cdi.CDIServiceLocator;

/**  Criado por: Eber Lasso  **/

@FacesConverter(forClass = Usuario.class)
public class UsuarioConverter implements Converter {
	/************************************** PROPRIEDADES ********************************************/
	
	//@Inject
	private Usuarios usuarios;
	

	/************************************** CONSTRUTOR ********************************************/
	
	public UsuarioConverter() {		
		this.usuarios = CDIServiceLocator.getBean(Usuarios.class);
	}
	

	/************************************** GETS ********************************************/
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Usuario retorno = null;
		
		if (value != null) {			
			retorno = usuarios.porId(new Long(value)) ;			
		}
		return retorno;
	}	

	
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((Usuario) value).getId().toString();			
		}
		
		return "";
	}

	/************************************** SETS ********************************************/

	/************************************** MÉTODOS ********************************************/

	/************************************** hashCode E equals ********************************************/

}

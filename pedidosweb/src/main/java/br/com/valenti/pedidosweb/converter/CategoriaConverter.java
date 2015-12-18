package br.com.valenti.pedidosweb.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.valenti.pedidosweb.model.def.Categoria;
import br.com.valenti.pedidosweb.model.repository.Categorias;
import br.com.valenti.pedidosweb.util.cdi.CDIServiceLocator;

/**  Criado por: Eber Lasso  **/

@FacesConverter(forClass = Categoria.class)
public class CategoriaConverter implements Converter {
	/************************************** PROPRIEDADES ********************************************/
	
	//@Inject
	private Categorias categorias;
	

	/************************************** CONSTRUTOR ********************************************/
	
	public CategoriaConverter() {		
		this.categorias = CDIServiceLocator.getBean(Categorias.class);
	}
	

	/************************************** GETS ********************************************/
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Categoria retorno = null;
		
		if (value != null) {
			Long id = new Long(value);
			return categorias.porId(id) ;			
		}
		return retorno;
		
	}	

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((Categoria) value).getId().toString();			
		}
		return "";
	}

	/************************************** SETS ********************************************/

	/************************************** MÉTODOS ********************************************/

	/************************************** hashCode E equals ********************************************/

}

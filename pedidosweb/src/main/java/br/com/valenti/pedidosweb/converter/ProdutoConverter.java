package br.com.valenti.pedidosweb.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.valenti.pedidosweb.model.def.Produto;
import br.com.valenti.pedidosweb.model.repository.Produtos;
import br.com.valenti.pedidosweb.util.cdi.CDIServiceLocator;

/**  Criado por: Eber Lasso  **/

@FacesConverter(forClass = Produto.class)
public class ProdutoConverter implements Converter {
	/************************************** PROPRIEDADES ********************************************/
	
	//@Inject
	private Produtos produtos;
	

	/************************************** CONSTRUTOR ********************************************/
	
	public ProdutoConverter() {		
		this.produtos = CDIServiceLocator.getBean(Produtos.class);
	}
	

	/************************************** GETS ********************************************/
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Produto retorno = null;
		
		if (value != null) {
			Long id = new Long(value);
			return produtos.porId(id) ;			
		}
		return retorno;
		
	}	

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Produto produto = (Produto) value;
			if (produto.getId() == null) {				
				return  null;
			}
			else{				
				return produto.getId().toString();		
			}
		}
		return "";
	}

	/************************************** SETS ********************************************/

	/************************************** MÉTODOS ********************************************/

	/************************************** hashCode E equals ********************************************/
}



package br.com.valenti.pedidosweb.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.valenti.pedidosweb.model.def.ItemEstoque;
import br.com.valenti.pedidosweb.model.def.Produto;
import br.com.valenti.pedidosweb.model.repository.Itens_Estoque;
import br.com.valenti.pedidosweb.model.repository.Produtos;
import br.com.valenti.pedidosweb.util.cdi.CDIServiceLocator;

/**  Criado por: Eber Lasso  **/

@FacesConverter(forClass = ItemEstoque.class)
public class ItemEstoqueConverter implements Converter {
	/************************************** PROPRIEDADES ********************************************/
	
	//@Inject
	private Itens_Estoque itensestoque;
	

	/************************************** CONSTRUTOR ********************************************/
	
	public ItemEstoqueConverter() {		
		this.itensestoque = CDIServiceLocator.getBean(Itens_Estoque.class);
	}
	

	/************************************** GETS ********************************************/
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		ItemEstoque retorno = null;
		
		if (value != null) {
			Long id = new Long(value);
			return itensestoque.porId(id) ;			
		}
		return retorno;
		
	}	

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			ItemEstoque itemestoque = (ItemEstoque) value;
			if (itemestoque.getId() == null) {				
				return  null;
			}
			else{				
				return itemestoque.getId().toString();		
			}
		}
		return "";
	}

	/************************************** SETS ********************************************/

	/************************************** MÉTODOS ********************************************/

	/************************************** hashCode E equals ********************************************/
}



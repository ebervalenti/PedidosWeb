package br.com.valenti.pedidosweb.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.valenti.pedidosweb.model.def.Pessoa;
import br.com.valenti.pedidosweb.model.repository.Pessoas;
import br.com.valenti.pedidosweb.util.cdi.CDIServiceLocator;

/**  Criado por: Eber Lasso  **/

@FacesConverter(forClass = Pessoa.class)
public class PessoaConverter implements Converter {
	/************************************** PROPRIEDADES ********************************************/
	
	//@Inject
	private Pessoas pessoas;
	

	/************************************** CONSTRUTOR ********************************************/
	
	public PessoaConverter() {		
		this.pessoas = (Pessoas) CDIServiceLocator.getBean(Pessoas.class);
	}
	

	/************************************** GETS ********************************************/	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Pessoa retorno = null;
		
		if (value != null) {			
			retorno =  this.pessoas.porId(new Long(value)) ;			
		}
		return retorno;	
	}	
		

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((Pessoa) value).getId().toString();			
		}
		return "";
	}

	/************************************** SETS ********************************************/

	/************************************** MÉTODOS ********************************************/

	/************************************** hashCode E equals ********************************************/

}

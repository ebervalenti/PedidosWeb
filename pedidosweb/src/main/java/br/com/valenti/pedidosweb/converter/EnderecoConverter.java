package br.com.valenti.pedidosweb.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.valenti.pedidosweb.model.def.Endereco;
import br.com.valenti.pedidosweb.model.repository.Empresas;
import br.com.valenti.pedidosweb.model.repository.Enderecos;
import br.com.valenti.pedidosweb.model.repository.Pedidos;
import br.com.valenti.pedidosweb.model.repository.Pessoas;
import br.com.valenti.pedidosweb.util.cdi.CDIServiceLocator;

/**  Criado por: Eber Lasso  **/

@FacesConverter(forClass = Endereco.class)
public class EnderecoConverter implements Converter {
	/************************************** PROPRIEDADES ********************************************/
	
	//@Inject
	private Enderecos enderecos;
	
	private Pessoas pessoas;
	
	private Empresas empresas;
	
	private Pedidos pedidos;
	

	/************************************** CONSTRUTOR ********************************************/
	
	public EnderecoConverter() {		
		this.enderecos = (Enderecos) CDIServiceLocator.getBean(Enderecos.class);		
		/*
		if (CDIServiceLocator.getBean(Pessoas.class) != null) {
			this.pessoas = (Pessoas) CDIServiceLocator.getBean(Pessoas.class);
			System.out.println("Converter 1");
		}
		else if (CDIServiceLocator.getBean(Empresas.class) != null) {
			this.empresas = (Empresas) CDIServiceLocator.getBean(Empresas.class);
			System.out.println("Converter 2");
		} else if(CDIServiceLocator.getBean(Pedidos.class) != null) {
			this.pedidos = (Pedidos) CDIServiceLocator.getBean(Pedidos.class);
			System.out.println("Converter 3");
		}
		*/	
	}
	

	/************************************** GETS ********************************************/	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Endereco retorno = null;		
		/*		
		if (CDIServiceLocator.getBean(Pessoas.class) != null) {
			this.pessoas = (Pessoas) CDIServiceLocator.getBean(Pessoas.class);
			System.out.println("Converter 11");
			if (value != null) {			
				retorno =  this.enderecos.porId(new Long(value), new Long(this.pessoas.pesquisar())) ;			
			}
			
		}
		else if (CDIServiceLocator.getBean(Empresas.class) != null) {
			this.empresas = (Empresas) CDIServiceLocator.getBean(Empresas.class);
			System.out.println("Converter 22");
		} else if(CDIServiceLocator.getBean(Pedidos.class) != null) {
			this.pedidos = (Pedidos) CDIServiceLocator.getBean(Pedidos.class);
			System.out.println("Converter 33");
		}
		*/		

		if (value != null) {
			Long id = new Long(value);
			return enderecos.porId(id) ;			
		}
		return retorno;	
	}
		
		

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((Endereco) value).getId().toString();			
		}
		return "";
	}

	/************************************** SETS ********************************************/

	/************************************** MÉTODOS ********************************************/

	/************************************** hashCode E equals ********************************************/

}

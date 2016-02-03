/**
 * 
 */
package br.com.valenti.pedidosweb.model.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.valenti.pedidosweb.model.def.ItemEstoque;
import br.com.valenti.pedidosweb.model.def.Pedido;
import br.com.valenti.pedidosweb.model.repository.filter.PedidosFilter;
import br.com.valenti.pedidosweb.security.Seguranca;
import br.com.valenti.pedidosweb.security.UsuarioSistema;
import br.com.valenti.pedidosweb.util.jpa.Transacional;
/**
 * @author Eber
 *
 */
public class Itens_Estoque implements Serializable {
	/************************************** PROPRIEDADES ********************************************/	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	@Inject
	private Seguranca  seguranca;
	

	/************************************** CONSTRUTOR ********************************************/

	/************************************** GETS ********************************************/

	/************************************** SETS ********************************************/
	
	/************************************** MÉTODOS ********************************************/
	
	@Transacional
	public ItemEstoque guardar(ItemEstoque item){
		return manager.merge(item);		
	}
	

	/************************************** hashCode E equals ********************************************/

}

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

import br.com.valenti.pedidosweb.model.def.Cliente;
import br.com.valenti.pedidosweb.model.def.Empresa;
import br.com.valenti.pedidosweb.model.def.Pessoa;
import br.com.valenti.pedidosweb.model.repository.filter.ClienteFilter;
import br.com.valenti.pedidosweb.security.Seguranca;

public class Clientes implements Serializable {

	/************************************** PROPRIEDADES ********************************************/
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	private Empresa empresa;
	
	@Inject
	private Seguranca seguranca;

	/************************************** CONSTRUTOR ********************************************/

	/************************************** GETS ********************************************/

	/************************************** SETS ********************************************/

	/************************************** MÉTODOS ********************************************/
	public Cliente guardar(Cliente cliente) {		
		return  manager.merge(cliente);
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> pesquisar(ClienteFilter filtro){
		//TODO IMPLEMENTAR OS TIPOS DE PESSOAS = CLIENTES, VENDEDORES, ETC...
		
		/* Session do hibernate faz pesquisa dinâmica - manager.unwrap(Session.class) - 	
		desempacota a Session e atribui para a variável session*/
		Session session = manager.unwrap(Session.class);				 
		
		/* A interface Criteria recebe uma sessão do Produto.class para criar o critério*/
		Criteria criteria = session.createCriteria(Cliente.class)
				.createAlias("empresa", "e");
		
		if (seguranca.getUsuario().getEmpresa().getId() != 999999) {
			criteria.add(Restrictions.eq("e.id",seguranca.getUsuario().getEmpresa().getId()));			
		}
		
		if (StringUtils.isNotBlank(filtro.getNome())) {
			criteria.add(Restrictions.ilike("nome", filtro.getNome(),MatchMode.ANYWHERE));		
		}		
		return criteria.addOrder(Order.asc("nome")).list();				
	}

	public Cliente porId(Long id) {		
		return manager.find(Cliente.class, id);
	}

	/************************************** hashCode E equals ********************************************/
	
	

}

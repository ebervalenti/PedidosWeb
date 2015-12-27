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

import br.com.valenti.pedidosweb.model.def.Pessoa;
import br.com.valenti.pedidosweb.model.def.Produto;
import br.com.valenti.pedidosweb.model.def.Usuario;
import br.com.valenti.pedidosweb.model.repository.filter.PessoaFilter;

/**  Criado por: Eber Lasso  **/

public class Pessoas implements Serializable {
	/************************************** PROPRIEDADES ********************************************/
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	/************************************** CONSTRUTOR ********************************************/

	
	/************************************** MÉTODOS ********************************************/	
	public Pessoa porId(Long id) {
		return manager.find(Pessoa.class, id);
	}	
	
	@SuppressWarnings("unchecked")
	public List<Pessoa> pesquisar(PessoaFilter filtro){
		//TODO IMPLEMENTAR OS TIPOS DE PESSOAS = CLIENTES, VENDEDORES, ETC...
		
		/* Session do hibernate faz pesquisa dinâmica - manager.unwrap(Session.class) - 	
		desempacota a Session e atribui para a variável session*/
		Session session = manager.unwrap(Session.class); 
		
		/* A interface Criteria recebe uma sessão do Produto.class para criar o critério*/
		Criteria criteria = session.createCriteria(Pessoa.class);
		
		if (StringUtils.isNotBlank(filtro.getNome())) {
			criteria.add(Restrictions.ilike("nome", filtro.getNome(),MatchMode.ANYWHERE));		
		}		
		return criteria.addOrder(Order.asc("nome")).list();				
	}
}

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
import br.com.valenti.pedidosweb.model.def.Produto;
import br.com.valenti.pedidosweb.model.repository.filter.Itemestoquefilter;
import br.com.valenti.pedidosweb.model.repository.filter.PedidosFilter;
import br.com.valenti.pedidosweb.model.repository.filter.ProdutoFilter;
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
	public ItemEstoque salvar(ItemEstoque item){
		return manager.merge(item);		
	}
	
	@SuppressWarnings("unchecked")
	public List<ItemEstoque> pesquisar(Itemestoquefilter pesquisa) {		
		
		/* Session do hibernate faz pesquisa dinâmica - manager.unwrap(Session.class) - 	
		desempacota a Session e atribui para a variável session*/
		Session session = manager.unwrap(Session.class); 
		
		/* A interface Criteria recebe uma sessão do Produto.class para criar o critério*/
		Criteria criteria = session.createCriteria(ItemEstoque.class)
				.createAlias("produto", "p");	
		
		if (StringUtils.isNotBlank(pesquisa.getNome())) {
			//criteria.add(Restrictions.ilike("p.nome", produtofilter.getId(),MatchMode.ANYWHERE));
			criteria.add(Restrictions.ilike("p.nome", pesquisa.getNome(), MatchMode.ANYWHERE));
		}
		
		return criteria.addOrder(Order.asc("id")).list();		
	}

	public ItemEstoque porId(Long id) {		
		return manager.find(ItemEstoque.class, id);
	}	

	/************************************** hashCode E equals ********************************************/

}

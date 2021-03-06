/**
 * 
 */
package br.com.valenti.pedidosweb.model.repository;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.valenti.pedidosweb.model.def.ItemEstoque;
import br.com.valenti.pedidosweb.model.def.Produto;
import br.com.valenti.pedidosweb.model.repository.filter.ProdutoFilter;
import br.com.valenti.pedidosweb.services.NegocioException;
import br.com.valenti.pedidosweb.util.jpa.Transacional;
import br.com.valenti.pedidosweb.util.jsf.FacesUtil;

/**  Criado por: Eber Lasso  **/

public class Produtos implements Serializable {
	/************************************** PROPRIEDADES ********************************************/
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	@Inject
	private Itens_Estoque addItemEstoque;
	
	private ItemEstoque item = new ItemEstoque();	

	/************************************** CONSTRUTOR ********************************************/

	
	/************************************** MÉTODOS ********************************************/

	public Produto guardar(Produto produto) {		
		return manager.merge(produto);	
		}	

	
	public Produto porSku(String sku) {
		String qlString = "from Produto where upper(sku) = :sku"; 		
		try {			
			return manager.createQuery(qlString, Produto.class)
					.setParameter("sku",sku.toUpperCase())
					.getSingleResult();
		}
		catch (NoResultException e) {			
			System.out.println("Erro em: Produtos/public Produto porSku(String sku)\n" + e.getMessage() );
			return null;
		}
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<Produto> pesquisar(ProdutoFilter pesquisa) {
		/* Session do hibernate faz pesquisa dinâmica - manager.unwrap(Session.class) - 	
		desempacota a Session e atribui para a variável session*/
		Session session = manager.unwrap(Session.class); 
		
		/* A interface Criteria recebe uma sessão do Produto.class para criar o critério*/
		Criteria criteria = session.createCriteria(Produto.class);		
		
		if (StringUtils.isNotBlank(pesquisa.getNome())) {
			criteria.add(Restrictions.ilike("nome", pesquisa.getNome(),MatchMode.ANYWHERE));		
		}
		
		return criteria.addOrder(Order.asc("nome")).list();		
	}
	
	public Produto porId(Long id) {
		return manager.find(Produto.class, id);
	}
	
	@Transacional
	public void excluir(Produto produto){
		try {
			produto = porId(produto.getId());			
			manager.remove(produto);
			manager.flush();
		} catch (PersistenceException e) {
			System.out.println("Erro em: Produtos / public void excluir(Produto produto)" );
			throw new NegocioException("Erro ao excuir produto. Erro: "+e.getMessage());
		}
		
		
	}


	public List<Produto> porNome(String nome) {		
		return null;
	}

	
		
		
	
	/************************************** hashCode E equals ********************************************/

}

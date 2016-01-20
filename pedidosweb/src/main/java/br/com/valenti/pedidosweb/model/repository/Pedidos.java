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

import br.com.valenti.pedidosweb.model.def.Pedido;
import br.com.valenti.pedidosweb.model.repository.filter.PedidosFilter;
import br.com.valenti.pedidosweb.security.Seguranca;
import br.com.valenti.pedidosweb.security.UsuarioSistema;
/**
 * @author Eber
 *
 */
public class Pedidos implements Serializable {
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
	
	//select filtrado	
	@SuppressWarnings("unchecked")
	public List<Pedido> filtrados(PedidosFilter filtro){
		Session session = this.manager.unwrap(Session.class);
		
		Criteria criteria = session.createCriteria(Pedido.class)
				//alias para determinar "c" como cliente
				.createAlias("cliente", "c")
				//alias para determinar "v" como vendedor
				.createAlias("vendedor", "v")
				//alias para determinar "e" como vendedor
				.createAlias("empresa", "e");
		
		System.out.println(filtro.getEmpresa());
		
		if (filtro.getEmpresa().getId() != 999999) {
			criteria.add(Restrictions.eq("e.id",filtro.getEmpresa().getId()));			
		}
		
		if (filtro.getNumPedidoIni() !=null) {
			// numPedidoIni = data inicio do pedido -  deve ser maior ou igual (ge = greater or equals) a getNumPedidoIni
			criteria.add(Restrictions.ge("id", filtro.getNumPedidoIni()));			
		}
		
		if (filtro.getNumPedidoFim() !=null) {
			// numPedidoFim = data inicio do pedido -  deve ser maior ou igual (ge = greater or equals) a getNumPedidoFim
			criteria.add(Restrictions.ge("id", filtro.getNumPedidoFim()));			
		}
				
		if (filtro.getDatePedidoIni() !=null) {
			// datePedidoIni = data inicio do pedido -  deve ser maior ou igual (ge = greater or equals) a getDatePedidoIni
			criteria.add(Restrictions.ge("dataCriacao", filtro.getDatePedidoIni()));			
		}
		
		if (filtro.getDatePedidoFim() !=null) {
			// datePedidoIni = data inicio do pedido -  deve ser maior ou igual (ge = greater or equals) a getDatePedidoIni
			criteria.add(Restrictions.ge("dataCriacao", filtro.getDatePedidoFim()));			
		}
		
		if (StringUtils.isNotBlank(filtro.getCliente())) {
			// acessamos o nome do cliente associado ao pedido pelo alias "c", criado anteriormente
			criteria.add(Restrictions.ilike("c.nome", filtro.getCliente(),MatchMode.ANYWHERE));			
		}
		
		if (StringUtils.isNotBlank(filtro.getVendedor())) {
			// acessamos o nome do cliente associado ao pedido pelo alias "v", criado anteriormente
			criteria.add(Restrictions.ilike("v.nome", filtro.getCliente(),MatchMode.ANYWHERE));			
		}
		
		if (filtro.getStatusPedido() != null && filtro.getStatusPedido().length > 0) {
			// acessamos o nome do cliente associado ao pedido pelo alias "c", criado anteriormente
			criteria.add(Restrictions.in("status", filtro.getStatusPedido()));			
		}
		
		return criteria.addOrder(Order.asc("id")).list();
	}	
	
	public Pedido porId(Long id){
		return manager.find(Pedido.class, id);
		
	}
	
	public List<Pedido> carregarSubcategorias(Pedido categoriaPai){
		return manager.createQuery("from Pedido where categoriaPai = :raiz ", Pedido.class)
				.setParameter("raiz", categoriaPai)
				.getResultList();
	}	
	
	public Pedido guardar(Pedido pedido) {		
		return this.manager.merge(pedido);
		
	}
	

	/************************************** hashCode E equals ********************************************/

}

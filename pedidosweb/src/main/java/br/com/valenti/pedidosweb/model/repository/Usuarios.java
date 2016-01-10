/**
 * 
 */
package br.com.valenti.pedidosweb.model.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;

import br.com.valenti.pedidosweb.model.def.Categoria;
import br.com.valenti.pedidosweb.model.def.Produto;
import br.com.valenti.pedidosweb.model.def.Usuario;

/**  Criado por: Eber Lasso  **/

public class Usuarios implements Serializable {
	/************************************** PROPRIEDADES ********************************************/
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	/************************************** CONSTRUTOR ********************************************/

	
	/************************************** MÉTODOS ********************************************/	
	public Usuario porId(Long id) {
		return this.manager.find(Usuario.class, id);
	}	
	
	public List<Usuario> vendedores(){	
		//TODO implementar definição 
		return this.manager.createQuery("from Usuario ", Usuario.class)
				.getResultList();		
	}

	public Usuario porUserName(String username) {
Usuario usuario = null;
		
		try {
			return this.manager.createQuery(" from Ususario where lower(username) = :username ", 
					Usuario.class).setParameter("username", username.toLowerCase()).
					getSingleResult();				
		} catch (Exception e) {
			// TODO: nenhum usuário encontrado com o esername informado
		}
		return usuario;		
	}
}

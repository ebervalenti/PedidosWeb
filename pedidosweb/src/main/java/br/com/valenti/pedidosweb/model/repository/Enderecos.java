package br.com.valenti.pedidosweb.model.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.valenti.pedidosweb.model.def.Endereco;
import br.com.valenti.pedidosweb.model.def.Pedido;

public class Enderecos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	/************************************** PROPRIEDADES ********************************************/

	/************************************** CONSTRUTOR ********************************************/

	/************************************** GETS ********************************************/

	/************************************** SETS ********************************************/


	/************************************** MÉTODOS ********************************************/
	/*
	public List <Endereco> porId(Long id, int objectId) {
		return manager.createQuery("from Endereco where id = :id  and :objectId", Endereco.class)
				.setParameter("id", id).setParameter("objectId", objectId)
				.getResultList();
	}
	*/
	
	public List <Endereco> porId(Long id) {
		return manager.createQuery("from Endereco where id = :id ", Endereco.class)
				.setParameter("id", id)
				.getResultList();
	}

	/************************************** hashCode E equals ********************************************/

}

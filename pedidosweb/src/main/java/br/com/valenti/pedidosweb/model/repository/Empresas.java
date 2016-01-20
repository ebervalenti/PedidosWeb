package br.com.valenti.pedidosweb.model.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.valenti.pedidosweb.model.def.Empresa;

public class Empresas implements Serializable {

	/************************************** PROPRIEDADES ********************************************/
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	/************************************** CONSTRUTOR ********************************************/

	/************************************** GETS ********************************************/

	/************************************** SETS ********************************************/

	/************************************** MÉTODOS ********************************************/
	public Empresa porId(Long id) {		
		return manager.find(Empresa.class, id);
	}

	public Empresa guardar(Empresa empresa) {		
		return manager.merge(empresa);
	}

	/************************************** hashCode E equals ********************************************/

}

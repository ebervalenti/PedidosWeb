/**
 * 
 */
package br.com.valenti.pedidosweb.model.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.valenti.pedidosweb.model.def.Categoria;
/**
 * @author Eber
 *
 */
public class Categorias implements Serializable {
	/************************************** PROPRIEDADES ********************************************/	
	private static final long serialVersionUID = 1L;
	
	@Inject
	EntityManager manager;

	/************************************** CONSTRUTOR ********************************************/

	/************************************** GETS ********************************************/

	/************************************** SETS ********************************************/
	
	/************************************** MÉTODOS ********************************************/
	
	
	public List<Categoria> raizes(){
		return manager.createQuery("from Categoria where categoriaPai is null", Categoria.class).getResultList();
	}
	
	public Categoria porId(Long id){
		return manager.find(Categoria.class, id);
		
	}
	
	public List<Categoria> carregarSubcategorias(Categoria categoriaPai){
		return manager.createQuery("from Categoria where categoriaPai = :raiz ", Categoria.class)
				.setParameter("raiz", categoriaPai)
				.getResultList();
	}
	

	/************************************** hashCode E equals ********************************************/

}

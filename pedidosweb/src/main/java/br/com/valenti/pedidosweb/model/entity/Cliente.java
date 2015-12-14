package br.com.valenti.pedidosweb.model.entity;


import java.io.Serializable;

import javax.persistence.Entity;

import br.com.valenti.pedidosweb.model.def.Pessoa;

/**
 *
 * @author Eber Lasso
 */
@Entity
public class Cliente extends Pessoa implements Serializable{ 
	/******************** ATRIBUTOS ************************/
	private static final long serialVersionUID = 1L;
	 
}

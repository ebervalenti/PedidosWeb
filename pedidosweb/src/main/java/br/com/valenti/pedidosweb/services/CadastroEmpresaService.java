/**
 * 
 */
package br.com.valenti.pedidosweb.services;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.valenti.pedidosweb.model.def.Empresa;
import br.com.valenti.pedidosweb.model.repository.Empresas;
import br.com.valenti.pedidosweb.util.jpa.Transacional;

/**  Criado por: Eber Lasso  **/

public class CadastroEmpresaService implements Serializable {
	/************************************** PROPRIEDADES ********************************************/
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Empresas empresas;
	/************************************** CONSTRUTOR ********************************************/

	/************************************** GETS ********************************************/

	/************************************** SETS ********************************************/

	/************************************** MÉTODOS ********************************************/
	@Transacional /* interceptador para criar a transação - se este método executar sem erros 
	 					essa anotação fará o commit se não fará o rollback */ 
	public Empresa salvar(Empresa empresa){	
		return empresas.guardar(empresa);
		 
	 }
	/************************************** hashCode E equals ********************************************/

}

package br.com.valenti.pedidosweb.services;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.valenti.pedidosweb.model.def.Cliente;
import br.com.valenti.pedidosweb.model.repository.Clientes;
import br.com.valenti.pedidosweb.model.repository.Empresas;
import br.com.valenti.pedidosweb.util.jpa.Transacional;

public class CadastroClienteService implements Serializable {

	/************************************** PROPRIEDADES ********************************************/
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Clientes clientes;

	/************************************** CONSTRUTOR ********************************************/

	/************************************** GETS ********************************************/

	/************************************** SETS ********************************************/

	/************************************** MÉTODOS ********************************************/
	@Transacional /* interceptador para criar a transação - se este método executar sem erros 
		essa anotação fará o commit se não fará o rollback */ 
	public Cliente salvar(Cliente cliente) {		
		return clientes.guardar(cliente);
	}

	/************************************** hashCode E equals ********************************************/

}

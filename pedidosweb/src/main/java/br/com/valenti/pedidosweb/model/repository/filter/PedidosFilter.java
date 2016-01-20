/**
 * 
 */
package br.com.valenti.pedidosweb.model.repository.filter;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import br.com.valenti.pedidosweb.model.def.Empresa;
import br.com.valenti.pedidosweb.model.def.Pedido;
import br.com.valenti.pedidosweb.model.enumeration.StatusPedido;
import br.com.valenti.pedidosweb.security.Seguranca;
import br.com.valenti.pedidosweb.validation.SKU;

/**  Criado por: Eber Lasso  **/

public class PedidosFilter implements Serializable {

	/************************************** PROPRIEDADES ********************************************/
	private static final long serialVersionUID = 1L;
	
	private Long numPedidoIni;
	private Long numPedidoFim;
	
	private Date datePedidoIni;
	private Date datePedidoFim;
	
	private String vendedor;
	private String cliente;
	
	private StatusPedido[] statusPedido;
	
	private Empresa empresa;
	
	@Inject
	private Seguranca seguranca;

	/************************************** CONSTRUTOR ********************************************/

	/************************************** GETS  ********************************************/
	public Long getNumPedidoIni() {
		return numPedidoIni;
	}

	public Long getNumPedidoFim() {
		return numPedidoFim;
	}

	public Date getDatePedidoIni() {
		return datePedidoIni;
	}

	public Date getDatePedidoFim() {
		return datePedidoFim;
	}

	public String getVendedor() {
		return vendedor;
	}

	public String getCliente() {
		return cliente;
	}

	public StatusPedido[] getStatusPedido() {
		return statusPedido;
	}	

	public Empresa getEmpresa() {
		return empresa;
	}

	/************************************** SETS ********************************************/
	
	public void setNumPedidoIni(Long numPedidoIni) {
		this.numPedidoIni = numPedidoIni;
	}

	public void setNumPedidoFim(Long numPedidoFim) {
		this.numPedidoFim = numPedidoFim;
	}

	public void setDatePedidoIni(Date datePedidoIni) {
		this.datePedidoIni = datePedidoIni;
	}

	public void setDatePedidoFim(Date datePedidoFim) {
		this.datePedidoFim = datePedidoFim;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public void setStatusPedido(StatusPedido[] statusPedido) {
		this.statusPedido = statusPedido;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}		
	/************************************** MÉTODOS ********************************************/

	/************************************** hashCode E equals ********************************************/

}

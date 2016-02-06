package br.com.valenti.pedidosweb.controller.cliente;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.valenti.pedidosweb.model.def.Cliente;
import br.com.valenti.pedidosweb.model.def.Empresa;
import br.com.valenti.pedidosweb.model.def.Endereco;
import br.com.valenti.pedidosweb.model.def.Estoque;
import br.com.valenti.pedidosweb.model.enumeration.FisicaJuridica;
import br.com.valenti.pedidosweb.model.enumeration.StatusPedido;
import br.com.valenti.pedidosweb.model.repository.filter.ClienteFilter;
import br.com.valenti.pedidosweb.services.CadastroClienteService;
import br.com.valenti.pedidosweb.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroClienteBean implements Serializable {
	/************************************** PROPRIEDADES ********************************************/
	private static final long serialVersionUID = 1L;
	
	private Cliente cliente;
	
	@Inject
	private CadastroClienteService cadastroclienteservice;
	
	private FisicaJuridica fj;
	

	/************************************** CONSTRUTOR ********************************************/	
	public CadastroClienteBean(){
		limpar();
	}

	/************************************** GETS ********************************************/
	public Cliente getCliente() {
			return cliente;
		}	

	public FisicaJuridica getFj() {
		return fj;
	}

	/************************************** SETS ********************************************/
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;		
	}

	public void setFj(FisicaJuridica fj) {
		this.fj = fj;
	}

	/************************************** MÉTODOS ********************************************/	
	public boolean isFisica(){
		
		System.out.println("222==="+fj.getDescricao());
		return this.cliente.getFj() == fj.FISICA;		
	}
	
	public boolean isJuridica(){
		
		System.out.println("444==="+fj.getDescricao());
		return this.cliente.getFj() == fj.JURIDICA;		
	}
	
	public void limpar(){		
		this.cliente 	= 	new Cliente();	
		this.cliente.setFj(fj);
		this.cliente.setEndereco(new Endereco());		
	}
	
	public void salvar(){		
		this.cliente = cadastroclienteservice.salvar(this.cliente);
		
		FacesUtil.addInfoMessage("Cliente "+ this.cliente.getId()+" - "+this.cliente.getNome()+
				" salvo com sucesso!");		
		limpar();
    }
	
	public boolean isEditando(){
		return this.cliente.getId()!= null; //troca o label da tela de empresa para edição ou nova empresa		
	}
	
	public FisicaJuridica[] getpessoaFJ(){
		return FisicaJuridica.values();
	}	
	
	public void atualizaCadastro() {	
		if (this.cliente != null) {			
			this.cliente.atualizaCadastroFisicaJuridica(this.fj);
			System.out.println("fffffffffffffffff");
		}		
	}

	/************************************** hashCode E equals ********************************************/

}

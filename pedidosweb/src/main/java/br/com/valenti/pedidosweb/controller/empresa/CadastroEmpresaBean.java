package br.com.valenti.pedidosweb.controller.empresa;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.valenti.pedidosweb.model.def.Empresa;
import br.com.valenti.pedidosweb.model.def.Endereco;
import br.com.valenti.pedidosweb.services.CadastroEmpresaService;
import br.com.valenti.pedidosweb.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroEmpresaBean implements Serializable {
	/************************************** PROPRIEDADES ********************************************/
	private static final long serialVersionUID = 1L;
	
	private Empresa empresa;
	
	@Inject
	private CadastroEmpresaService cadastroempresaservice;

	/************************************** CONSTRUTOR ********************************************/
	public CadastroEmpresaBean() {		
		limpar();
	}

	/************************************** GETS ********************************************/
	public Empresa getEmpresa() {
		return empresa;
	}

	/************************************** SETS ********************************************/
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	/************************************** MÉTODOS ********************************************/
	public boolean isEditando(){
		return this.empresa.getId()!= null; //troca o label da tela de empresa para edição ou nova empresa		
	}
	
	public void limpar(){
		this.empresa = new Empresa();
		this.empresa.setEndereco(new Endereco());
	}
	
	public void salvar(){
		this.empresa = cadastroempresaservice.salvar(this.empresa);
		
		FacesUtil.addInfoMessage("Produto "+ this.empresa.getId()+" - "+this.empresa.getNomeFantasia() +
				" salvo com sucesso!");
		
		limpar();
    }


	/************************************** hashCode E equals ********************************************/

}

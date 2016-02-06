package br.com.valenti.pedidosweb.model.repository.filter;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.valenti.pedidosweb.model.def.Empresa;
import br.com.valenti.pedidosweb.model.enumeration.FisicaJuridica;
import br.com.valenti.pedidosweb.security.Seguranca;

public class ClienteFilter implements Serializable {

	/************************************** PROPRIEDADES ********************************************/
	private static final long serialVersionUID = 1L;
	
	private String nome; // pesquisar por nome	
	
	//TODO implementar o restante de pesquuisas de pessoas
	
	private Empresa empresa;
	
	@Inject
	private Seguranca seguranca;
	
	private FisicaJuridica[] fisicaJurica; 

	/************************************** CONSTRUTOR ********************************************/

	/************************************** GETS ********************************************/
	public String getNome() {
		return nome;
	}	
	
	public Empresa getEmpresa() {
		return empresa;
	}
	
	public Seguranca getSeguranca() {
		return seguranca;
	}	

	public FisicaJuridica[] getFisicaJurica() {
		return fisicaJurica;
	}

	/************************************** SETS ********************************************/
	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}		
	
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public void setSeguranca(Seguranca seguranca) {
		this.seguranca = seguranca;
	}

	public void setFisicaJurica(FisicaJuridica[] fisicaJurica) {
		this.fisicaJurica = fisicaJurica;
	}
	

	/************************************** MÉTODOS ********************************************/

	/************************************** hashCode E equals ********************************************/

}

package br.com.valenti.pedidosweb.controller.produto;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.valenti.pedidosweb.model.def.Produto;
import br.com.valenti.pedidosweb.model.repository.Produtos;
import br.com.valenti.pedidosweb.model.repository.filter.ProdutoFilter;

@Named
@ViewScoped
public class PesquisaProdutoBean implements Serializable {
		
	/************************************** PROPRIEDADES ********************************************/
	private static final long serialVersionUID = 1L;
	
	private List<Produto> produtosFiltrados;
	
	@Inject
	private Produtos produtos;
	
	private ProdutoFilter filtro;
	/************************************** CONSTRUTOR ********************************************/
	
	public PesquisaProdutoBean(){
		filtro = new ProdutoFilter();
	}
	
	/************************************** GETS ********************************************/
	public void pesquisar(){
		produtosFiltrados = produtos.pesquisar(filtro);
	}

	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}
	
	public ProdutoFilter getFiltro() {
		return filtro;
	}
	
	/************************************** SETS ********************************************/

	
	/************************************** MÉTODOS ********************************************/

	
	
	/************************************** hashCode E equals ********************************************/

}

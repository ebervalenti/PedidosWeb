package br.com.valenti.pedidosweb.controller.produto;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.valenti.pedidosweb.model.def.Produto;
import br.com.valenti.pedidosweb.model.repository.Produtos;
import br.com.valenti.pedidosweb.model.repository.filter.ProdutoFilter;
import br.com.valenti.pedidosweb.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaProdutoBean implements Serializable {
		
	/************************************** PROPRIEDADES ********************************************/
	private static final long serialVersionUID = 1L;
	
	private List<Produto> produtosFiltrados;
	
	@Inject
	private Produtos produtos;
	
	private ProdutoFilter filtro;
	
	private Produto produtoSelecionado;
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

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}
	
	
	/************************************** SETS ********************************************/
	public void setProdutoSelecionado(Produto produtoSelecionado) {
			this.produtoSelecionado = produtoSelecionado;
		}
	
	/************************************** MÉTODOS ********************************************/

	public void excluir(){
		produtos.excluir(produtoSelecionado);
		produtosFiltrados.remove(produtoSelecionado);
		
		FacesUtil.addInfoMessage("Produto "+produtoSelecionado.getId()+" - "+
				produtoSelecionado.getNome()+" excluído com sucesso.");
	}
	
	/************************************** hashCode E equals ********************************************/

}

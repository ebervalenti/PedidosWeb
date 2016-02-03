package br.com.valenti.pedidosweb.controller.produto;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.valenti.pedidosweb.model.def.ItemEstoque;
import br.com.valenti.pedidosweb.model.def.Produto;
import br.com.valenti.pedidosweb.model.repository.Itens_Estoque;
import br.com.valenti.pedidosweb.model.repository.Produtos;
import br.com.valenti.pedidosweb.model.repository.filter.Itemestoquefilter;
import br.com.valenti.pedidosweb.model.repository.filter.ProdutoFilter;
import br.com.valenti.pedidosweb.security.Seguranca;
import br.com.valenti.pedidosweb.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaProdutoBean implements Serializable {
		
	/************************************** PROPRIEDADES ********************************************/
	private static final long serialVersionUID = 1L;
	
	private List<ItemEstoque> produtosFiltrados;
	

	@Inject
	private Itens_Estoque produtos;
	
	private Itemestoquefilter filtro;
	
	private ItemEstoque produtoSelecionado;
	
	@Inject
	private Seguranca seguranca;
	/************************************** CONSTRUTOR ********************************************/
	
	public PesquisaProdutoBean(){
		filtro = new Itemestoquefilter();
	}
	
	/************************************** GETS ********************************************/
	public void pesquisar(){	
		filtro.setEmpresa(seguranca.getUsuario().getEmpresa());
		produtosFiltrados = produtos.pesquisar(filtro);
	}
/*
	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}
	
	public ProdutoFilter getFiltro() {
		return filtro;
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}
	*/
	
	public List<ItemEstoque> getProdutosFiltrados() {
		return produtosFiltrados;
	}
	
	public Itemestoquefilter getFiltro() {
		return filtro;
	}
	
	public ItemEstoque getProdutoSelecionado() {
		return produtoSelecionado;
	}
	
	/************************************** SETS ********************************************/
	/*
	public void setProdutoSelecionado(Produto produtoSelecionado) {
			this.produtoSelecionado = produtoSelecionado;
		}
		*/
	
	
	public void setProdutoSelecionado(ItemEstoque produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}
	
	/************************************** MÉTODOS ********************************************/

	public void excluir(){
		produtos.excluir(produtoSelecionado);
		produtosFiltrados.remove(produtoSelecionado);
		
		FacesUtil.addInfoMessage("Produto "+produtoSelecionado.getId()+" - "+
				produtoSelecionado.getProduto().getNome()+" excluído com sucesso.");
	}

	
	/************************************** hashCode E equals ********************************************/

}

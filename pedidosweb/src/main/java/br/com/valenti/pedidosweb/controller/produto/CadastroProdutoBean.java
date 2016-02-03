package br.com.valenti.pedidosweb.controller.produto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.valenti.pedidosweb.model.def.Categoria;
import br.com.valenti.pedidosweb.model.def.Estoque;
import br.com.valenti.pedidosweb.model.def.ItemEstoque;
import br.com.valenti.pedidosweb.model.def.Produto;
import br.com.valenti.pedidosweb.model.repository.Categorias;
import br.com.valenti.pedidosweb.security.Seguranca;
import br.com.valenti.pedidosweb.services.CadastroProdutoService;
import br.com.valenti.pedidosweb.services.Itens_EstoqueService;
import br.com.valenti.pedidosweb.util.jsf.FacesUtil;



@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable{
	/************************************** PROPRIEDADES ********************************************/	
    private static final long serialVersionUID = 1L;
    
    private Produto produto;
    
    private List<Categoria> categoriasRaizes; 
    private List<Categoria> subcategorias; 
    
    private Categoria categoriaPai;
    
    @Inject
	private Categorias categorias;//Repository
    
    @Inject
    private CadastroProdutoService cadastroProdutoService;  
    
    private ItemEstoque itemestoque;
    
    private Estoque estoque;    
    
    @Inject
    private Seguranca seguranca;
    
    @Inject
    private Itens_EstoqueService addItemsEstoque;
   
    
  /************************************** CONSTRUTOR ********************************************/   
    public CadastroProdutoBean() {
    	seguranca = new Seguranca();
		limpar();
	}  
	
    
    /************************************** GETS ********************************************/
	public Produto getProduto() {	
		return produto;
	}
    
    public List<Categoria> getCategoriasRaizes() {
		return categoriasRaizes;
	}   

	public Categoria getCategoriaPai() {
		return categoriaPai;
	}	

	public List<Categoria> getSubcategorias() {
		return subcategorias;
	}	
	
	public ItemEstoque getItemestoque() {
		return itemestoque;
	}


	public Estoque getEstoque() {
		return estoque;
	}


	/************************************** SETS ********************************************/
	public void setProduto(Produto produto) {
		this.produto = produto;
		
		if (produto != null) {
			this.categoriaPai = produto.getCategoria().getCategoriaPai();
			
		}
	}
	    
    public void setCategoriasRaizes(List<Categoria> categoriasRaizes) {
		this.categoriasRaizes = categoriasRaizes;
	}    

	public void setCategoriaPai(Categoria categoriaPai) {
		this.categoriaPai = categoriaPai;
	}

	public void setSubcategorias(List<Categoria> subcategorias) {
		this.subcategorias = subcategorias;
	}
	
	public void setItemestoque(ItemEstoque itemestoque) {
		this.itemestoque = itemestoque;
	}


	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}


	/************************************** METODOS ********************************************/
	public void salvar(){		
		this.produto = cadastroProdutoService.salvar(this.produto);		
		FacesUtil.addInfoMessage("Produto "+ this.produto.getId()+" - "+this.produto.getNome()+" salvo com sucesso!");
		inserirItemEstoque(produto);
		limpar();
    }
	
	private void inserirItemEstoque(Produto produto) {	
		itemestoque.setEstoque(produto.getEstoque());
		itemestoque.setProduto(produto);
		itemestoque.setQuantidade(new BigDecimal(produto.getQuantidadeEstoque()));		
		addItemsEstoque.guardar(itemestoque);		
	}


	public void inicializar() {		
		if (FacesUtil.isNotPostBack()) {
			categoriasRaizes =  categorias.raizes();			
		}
		
		if (categoriaPai != null) {
			carregarSubCategorias();			
		}	
	}
	
	public void carregarSubCategorias() {
		subcategorias = categorias.carregarSubcategorias(categoriaPai);
		
	}
	
	public boolean isEditando(){
		return this.produto.getId()!= null; //troca o label da tela de cadastro para edição ou novo produto		
	}
	
	public void limpar(){		
		categoriaPai = null;
		subcategorias = new ArrayList<>();
		this.produto = new Produto();
		this.produto.setEstoque(seguranca.getUsuario().getEmpresa().getEstoque());
		this.itemestoque = new ItemEstoque();		
	}
	
	
    /************************************** hashCode E equals ********************************************/
    
}

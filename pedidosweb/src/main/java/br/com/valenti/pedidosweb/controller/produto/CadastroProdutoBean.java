package br.com.valenti.pedidosweb.controller.produto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.valenti.pedidosweb.model.def.Categoria;
import br.com.valenti.pedidosweb.model.def.Produto;
import br.com.valenti.pedidosweb.model.repository.Categorias;
import br.com.valenti.pedidosweb.services.CadastroProdutoService;
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
   
    
  /************************************** CONSTRUTOR ********************************************/   
    public CadastroProdutoBean() {
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


	/************************************** METODOS ********************************************/
	public void salvar(){
		this.produto = cadastroProdutoService.salvar(this.produto);
		
		FacesUtil.addInfoMessage("Produto "+ this.produto.getSku()+" - "+this.produto.getNome()+" salvo com sucesso!");
		
		limpar();
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
		produto = new Produto();
		categoriaPai = null;
		subcategorias = new ArrayList<>();	
	}
	
	
    /************************************** hashCode E equals ********************************************/
    
}

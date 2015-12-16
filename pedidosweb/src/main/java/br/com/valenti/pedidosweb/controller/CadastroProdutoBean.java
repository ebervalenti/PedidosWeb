package br.com.valenti.pedidosweb.controller;

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
		produto = new Produto();		
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
		
		FacesUtil.addInfoMessage("Produto salvo com sucesso!");
    }
	
	public void inicializar() {		
		if (FacesUtil.isNotPostBack()) {
			categoriasRaizes =  categorias.raizes();			
		}
		
	}
	
	public void carregarSubCategorias() {
		subcategorias = categorias.carregarSubcategorias(categoriaPai);
		
	}	
	
    /************************************** hashCode E equals ********************************************/
    
}

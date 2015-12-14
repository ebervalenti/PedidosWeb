package br.com.valenti.pedidosweb.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.valenti.pedidosweb.model.def.Categoria;
import br.com.valenti.pedidosweb.model.def.Produto;



@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable{
	/************************************** PROPRIEDADES ********************************************/	
    private static final long serialVersionUID = 1L;
    
    private Produto produto;
    
    private List<Categoria> categoriasRaizes;    
    
    
    /************************************** GETS ********************************************/
	public Produto getProduto() {
		return produto;
	}
    
    public List<Categoria> getCategoriasRaizes() {
		return categoriasRaizes;
	}

	/************************************** SETS ********************************************/
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	    
    public void setCategoriasRaizes(List<Categoria> categoriasRaizes) {
		this.categoriasRaizes = categoriasRaizes;
	}

	/************************************** METODOS ********************************************/
	public void salvar(){    
		System.out.println("OK");
    }

	public CadastroProdutoBean() {
		produto = new Produto();
	}
	
	public void inicializar() {
		System.out.println("Inicializando ... ");
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PedidosWebPU");
        EntityManager manager = factory.createEntityManager();                 	   
		
		//S/tring qlString = "form Categoria";		
		
		//categoriasRaizes=new ArrayList<>();
		categoriasRaizes =  manager.createQuery("form Categoria", Categoria.class).getResultList();
		
		manager.close();

	}
	
	
    /************************************** hashCode E equals ********************************************/
    
}

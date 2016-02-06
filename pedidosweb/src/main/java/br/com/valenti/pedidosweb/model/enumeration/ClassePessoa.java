package br.com.valenti.pedidosweb.model.enumeration;

/**
 *
 * @author Eber Lasso
 */
public enum ClassePessoa {
	/************************************** PROPRIEDADES ********************************************/
    CLIENTE("Cliente"),
    VENDEDORES("Vendedores"), 
    GERENTES("Gerentes");
    
    private String descricao;
    /************************************** CONSTRUTOR ********************************************/

	private ClassePessoa(String descricao) {
		this.descricao = descricao;
	}    
    /************************************** GETS ********************************************/	
	public String getDescricao() {
		return descricao;
	}
    /************************************** SETS ********************************************/

	/************************************** MÉTODOS ********************************************/

	/************************************** hashCode E equals ********************************************/
}

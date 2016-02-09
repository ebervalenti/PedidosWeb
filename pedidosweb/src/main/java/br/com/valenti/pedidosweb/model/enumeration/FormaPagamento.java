package br.com.valenti.pedidosweb.model.enumeration;

/**
 *
 * @author Eber Lasso
 */
public enum FormaPagamento {
    A_VISTA("A vista"), 
    A_PRAZO("A prazo");
	
	private String descricao;

	private FormaPagamento(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
	
}

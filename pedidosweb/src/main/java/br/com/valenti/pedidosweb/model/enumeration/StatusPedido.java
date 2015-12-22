package br.com.valenti.pedidosweb.model.enumeration;

/**
 *
 * @author Eber Lasso
 */
public enum StatusPedido {
    ORCAMENTO("Orçamento"), 
    EMITIDO("Emitido"), 
    CANCELAD0("Cancelado");
	
	private String descricao;
	
	private StatusPedido(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
}

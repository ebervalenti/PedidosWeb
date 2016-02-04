package br.com.valenti.pedidosweb.model.enumeration;

/**
 *
 * @author Eber Lasso
 */
public enum Operacao {
    ENTRADA("Entrada"), 
    SAIDA("Saída");
	
	private String descricao;
	
	private Operacao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
}

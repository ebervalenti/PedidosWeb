package br.com.valenti.pedidosweb.model.enumeration;

/**
 *
 * @author Eber Lasso
 */
public enum FormaPagamento {
    DINHEIRO("Dinheiro"), 
    CARTAO_CREDITO("Cartão de Crédito"), 
    CARTAO_DEBITO("Cartão de Débito"), 
    CHEQUE("Cheque"), 
    BOLETO("Boleto"), 
    DEPOSITO("Depósito");
	
	private String descricao;

	private FormaPagamento(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
	
}

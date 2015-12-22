package br.com.valenti.pedidosweb.model.enumeration;

public enum FisicaJuridica {
	FISICA("Física"), 
	JURIDICA("Jurídica");
	
	private String descricao; 
	
	private FisicaJuridica(String descricao) {
		this.descricao = descricao;	
	}

	public String getDescricao() {
		return descricao;
	}
	
	

}

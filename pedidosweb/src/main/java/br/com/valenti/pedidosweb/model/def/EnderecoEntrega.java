package br.com.valenti.pedidosweb.model.def;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Eber Lasso
 */

@Embeddable
public class EnderecoEntrega implements Serializable{
	/************************************** PROPRIEDADES ********************************************/
	private static final long serialVersionUID = 1L;
	
	@NotBlank @Size(max=150)
	@Column(length=150, nullable=false)
	private String logradouro;
	
	@NotBlank @Size(max=20)
	@Column(length=20, nullable=false)
	private String numero;
	
	@NotBlank @Size(max=150)
	private String complemento;
	
	@NotBlank @Size(max=60)
	private String cidade;
	
	
	private String uf;
	
	@NotBlank @Size(max=9)
	private String cep;
	
	/************************************** GETS E SETS ********************************************/
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	
}

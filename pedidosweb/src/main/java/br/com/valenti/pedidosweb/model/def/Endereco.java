package br.com.valenti.pedidosweb.model.def;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Eber Lasso
 */

@Entity
@Table(name = "endereco")
public class Endereco implements Serializable{
	/************************************** PROPRIEDADES ********************************************/
	private static final long serialVersionUID = 1L;	
	
	private Long	id;
	private String logradouro;		
	private String numero;
	private String complemento;
	private String cidade;
	private String uf;
	private String cep;
	/************************************** GETS E SETS ********************************************/
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}	
	
	public void setId(Long id) {
		this.id = id;
	}



	@NotBlank @Size(max = 150)
	@Column(name = "logradouro", nullable = false, length = 150)
	public String getLogradouro() {
		return logradouro;
	}
	

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	@NotBlank @Size(max = 20)
	@Column(name = "numero", nullable = false, length = 20)
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	@Size(max = 150)
	@Column(name = "complemento", length = 150)
	public String getComplemento() {
		return complemento;
	}
	
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	@NotBlank @Size(max = 60)
	@Column(name = "cidade", nullable = false, length = 60)
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	@NotBlank @Size(max = 60)
	@Column(name = "uf", nullable = false, length = 60)
	public String getUf() {
		return uf;
	}
	
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	@NotBlank @Size(max = 9)
	@Column(name = "cep", nullable = false, length = 9)
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}

	
	/************************************** hashCode E equals ********************************************/
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}

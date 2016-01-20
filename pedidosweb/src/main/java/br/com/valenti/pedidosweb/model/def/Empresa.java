package br.com.valenti.pedidosweb.model.def;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {
	/************************************** PROPRIEDADES ********************************************/
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String nomeFantasia;
	
	private String cnpj;
	
	private String razaoSocial;
	
	private Endereco endereco;

	/************************************** CONSTRUTOR ********************************************/

	/************************************** GETS ********************************************/
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	
	@Column(nullable = false, length = 100)
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	
	@NotBlank
	@Column(nullable = false, length = 50)
	public String getCnpj() {
		return cnpj;
	}
	
	@NotBlank
	@Column(nullable = false, length = 100)
	public String getRazaoSocial() {
		return razaoSocial;
	}

	@Embedded
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	/************************************** SETS ********************************************/
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	/************************************** MÉTODOS ********************************************/

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
		Empresa other = (Empresa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}

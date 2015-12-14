package br.com.valenti.pedidosweb.model.def;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import org.hibernate.mapping.Array;

import br.com.valenti.pedidosweb.model.enumeration.TipoPessoa;



@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa implements Serializable {
	
	/************************************** PROPRIEDADES ********************************************/

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length=100)
	private String nome;
	
	@Column(length=60)
	private String email;
	
	@Column(length=50)
	private String docRF;
	
	@Enumerated(EnumType.STRING)	
	private TipoPessoa tipo;
	
	@OneToMany(mappedBy = "pessoa", targetEntity = Endereco.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)	
	private List<Endereco> endereco = new ArrayList<Endereco>();

	/************************************** GETS E SETS ********************************************/
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getDocRF() {
		return docRF;
	}

	public void setDocRF(String docRF) {
		this.docRF = docRF;
	}		
	
	public TipoPessoa getTipo() {
		return tipo;
	}

	public void setTipo(TipoPessoa tipo) {
		this.tipo = tipo;
	}

	
	public List<Endereco> getEnderecos() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
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
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

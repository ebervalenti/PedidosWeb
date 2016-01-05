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
import javax.persistence.Table;

import org.hibernate.mapping.Array;

import br.com.valenti.pedidosweb.model.enumeration.FisicaJuridica;
import br.com.valenti.pedidosweb.model.enumeration.TipoPessoa;



@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {
	
	/************************************** PROPRIEDADES ********************************************/

	private static final long serialVersionUID = 1L;

	
	private Long id;
	private String nome;
	private String email;
	private String docRF;
	private TipoPessoa tipo;
	private FisicaJuridica fj;
	private List<Endereco> endereco = new ArrayList<>();

	/************************************** GETS E SETS ********************************************/
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable = false, length = 100)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(nullable = false, length = 255)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "doc_receita_federal", nullable = false, length = 14)
	public String getDocRF() {
		return docRF;
	}

	public void setDocRF(String docRF) {
		this.docRF = docRF;
	}		
	
	@Enumerated(EnumType.STRING)
	@Column(name="fisica_juridica", nullable = false, length = 10)
	public FisicaJuridica getFj() {
		return fj;
	}

	public void setFj(FisicaJuridica fj) {
		this.fj = fj;
	}
	
	
	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
	public List<Endereco> getEndereco() {
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

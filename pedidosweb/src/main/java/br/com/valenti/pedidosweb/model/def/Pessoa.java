package br.com.valenti.pedidosweb.model.def;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.valenti.pedidosweb.model.enumeration.FisicaJuridica;
import br.com.valenti.pedidosweb.model.enumeration.ClassePessoa;




@MappedSuperclass
public abstract class Pessoa implements Serializable {
	
	/************************************** PROPRIEDADES ********************************************/

	private static final long serialVersionUID = 1L;	
	
	private Long id;
	private String nome;
	private String email;
	private String docRF;
	private String docRG_Incr;
	private ClassePessoa classe;
	private FisicaJuridica fj;
	private Endereco endereco = new Endereco();
	private Empresa empresa;

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
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "pessoa_endereco", joinColumns = @JoinColumn(name="pessoa_id"),
			inverseJoinColumns = @JoinColumn(name = "endereco_id"))	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}		
	
	@NotNull
    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false)
	public Empresa getEmpresa() {
		return empresa;
	}
	
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}	
	
	@Column(name = "doc_rg_inscr", nullable = false, length = 14)
	public String getDocRG_Incr() {
		return docRG_Incr;
	}

	public void setDocRG_Incr(String docRG_Incr) {
		this.docRG_Incr = docRG_Incr;
	}	

	@Enumerated(EnumType.STRING)
	@Column(name="classe_pessoa", nullable = false, length = 10)
	public ClassePessoa getClasse() {
		return classe;
	}

	public void setClasse(ClassePessoa classe) {
		this.classe = classe;
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

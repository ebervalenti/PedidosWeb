package br.com.valenti.pedidosweb.model.def;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.mapping.Array;


@Entity
@Table(name = "estoque")
public class Estoque implements Serializable {

	/************************************** PROPRIEDADES ********************************************/
	private static final long serialVersionUID = 1L;
	
	private Long id;	
	
	private BigDecimal valorestoque = BigDecimal.ZERO; 
	
	private List<ItemEstoque> itenstoque = new ArrayList<ItemEstoque>();	

	/************************************** CONSTRUTOR ********************************************/

	/************************************** GETS ********************************************/
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}		

	@Column(nullable = false, length = 100)
	public BigDecimal getValorestoque() {
		return valorestoque;
	}	
	
	@NotNull
    @OneToMany(mappedBy="estoque", cascade=CascadeType.ALL, orphanRemoval=true, fetch = FetchType.LAZY)
	public List<ItemEstoque> getItenstoque() {
		return itenstoque;
	}

	/************************************** SETS ********************************************/

	public void setId(Long id) {
		this.id = id;
	}
	
	public void setValorestoque(BigDecimal valorestoque) {
		this.valorestoque = valorestoque;
	}
	
	public void setItenstoque(List<ItemEstoque> itenstoque) {
		this.itenstoque = itenstoque;
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
		Estoque other = (Estoque) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}		

	
	

}

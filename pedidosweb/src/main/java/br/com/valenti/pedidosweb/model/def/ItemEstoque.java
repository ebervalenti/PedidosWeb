package br.com.valenti.pedidosweb.model.def;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import br.com.valenti.pedidosweb.services.NegocioException;

@Entity
@Table(name = "item_estoque")
public class ItemEstoque implements Serializable {

	/************************************** PROPRIEDADES ********************************************/
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private BigDecimal quantidade;
	
	private Produto produto;
	
	private Estoque estoque;

	/************************************** CONSTRUTOR ********************************************/
	
	/************************************** GETS ********************************************/
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	@Column(nullable=false,precision=10, scale=2)
	public BigDecimal getQuantidade() {
		return quantidade;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="produto_id", nullable=false)
	public Produto getProduto() {
		return produto;
	}
	
	
    @OneToOne
    @JoinColumn(name="estoque_id", nullable=false)
	public Estoque getEstoque() {
		return estoque;
	}

	/************************************** SETS ********************************************/
	
	
	public void setId(Long id) {
		this.id = id;
	}	
	
	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}	
	
	public void setProduto(Produto produto) {
		this.produto = produto;	
	}	
	
	public void setEstoque(Estoque estoque) {
			this.estoque = estoque;
		}
	
	/************************************** MÉTODOS ********************************************/

	@Transient
    public void baixarEstoque(Integer quantidade) {
    	BigDecimal novaQuantidade = this.getQuantidade().subtract(new BigDecimal(quantidade));
    	if (novaQuantidade.compareTo(new BigDecimal(0)) < 0) {
			throw new NegocioException("Quantidade de estoque insuficiente para o produto:  "+
					this.produto.getId() +" - "+this.produto.getNome()+".");
		}    	
    	this.setQuantidade(novaQuantidade);  	
    }       
    
    @Transient
    public void adicionarEstoque(Integer quantidade) {
    	this.setQuantidade(getQuantidade().add(new BigDecimal(quantidade)));    	
    }  
	
    @Transient
    public void retirarEstoque(Integer quantidade) {
    	this.setQuantidade(getQuantidade().subtract(new BigDecimal(quantidade)));    	
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
		ItemEstoque other = (ItemEstoque) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



}

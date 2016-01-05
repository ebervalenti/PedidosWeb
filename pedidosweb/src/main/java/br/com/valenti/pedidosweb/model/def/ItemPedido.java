package br.com.valenti.pedidosweb.model.def;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Eber Lasso
 */

@Entity
@Table(name = "item_pedido")
public class ItemPedido implements Serializable{
	
	/************************************** PROPRIEDADES ********************************************/	
	
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	
	
    private Integer quantidade = 1;
	
	
    private BigDecimal valorUnitario = BigDecimal.ZERO;
    
	
	private Produto produto;
    
	
	private Pedido pedido;
    
    /************************************** GETS E SETS ********************************************/
	@Id
		@GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
	
    @Column(nullable = false, length = 3)
    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Column(name="valor_unitario", nullable=false, precision=10,scale=2)
    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    @ManyToOne
	@JoinColumn(name="produto_id",nullable=false)
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @ManyToOne
	@JoinColumn(name = "pedido_id", nullable=false)
    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    @Transient
    public BigDecimal getValorTotal() {	
		return this.getValorUnitario().multiply(new BigDecimal(this.getQuantidade()));		
	}
    
    /************************************** MÉTODOS ********************************************/	
    
    @Transient
	public boolean isProdutoAssociado() {
		return this.getProduto() != null && this.getProduto().getId() != null;
	}
    
    /************************************** hashCode E equals ********************************************/
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemPedido other = (ItemPedido) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }  

}

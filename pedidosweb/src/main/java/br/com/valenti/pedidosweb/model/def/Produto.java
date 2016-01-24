package br.com.valenti.pedidosweb.model.def;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.valenti.pedidosweb.services.NegocioException;
import br.com.valenti.pedidosweb.validation.SKU;

/**
 *
 * @author Eber Lasso
 */

@Entity
@Table(name="produto")
public class Produto implements Serializable{
	/************************************** PROPRIEDADES ********************************************/	
	private static final long serialVersionUID = 1L;
	
	
    private Long id;
    
	
    private String nome;
    
	
    //private String sku; 
    
	
    private BigDecimal valorUnitario;
    
    
    private Integer quantidadeEstoque;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name="categoria_id", nullable=false)
    private Categoria categoria;
    
    /************************************** GETS E SETS ********************************************/
    @Id
	@GeneratedValue	
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @NotBlank
	@Size(max = 80)
	@Column(nullable = false, length = 80)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    /* 
    @NotBlank @SKU
	@Column(nullable = false, length = 20, unique = true)
    public String getSku() {
        return sku;
    }
    Comentado para adaptar o sistema para a Criare
    

    public void setSku(String sku) {
        this.sku = sku.toUpperCase();
    }
    */
    @NotNull
    @Column(name="valor_unitario", nullable = false, precision=10, scale=2)
    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    
    @NotNull @Min(0)
    @Column(name="qtd_estoque", nullable=false,length=5)
    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }   
    
    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    @NotNull
	@ManyToOne
	@JoinColumn(name = "categoria_id", nullable = false)
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    
    @Transient
    public void baixarEstoque(Integer quantidade) {
    	int novaQuantidade = this.getQuantidadeEstoque() - quantidade;
    	if (novaQuantidade < 0) {
			throw new NegocioException("Quantidade de estoque insuficiente para o produto:  "+
					this.getId() +" - "+this.getNome()+".");
		}    	
    	this.setQuantidadeEstoque(novaQuantidade);  	
    }
       
    
    @Transient
    public void adicionarEstoque(Integer quantidade) {
    	this.setQuantidadeEstoque(getQuantidadeEstoque() + quantidade);    	
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
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }


}

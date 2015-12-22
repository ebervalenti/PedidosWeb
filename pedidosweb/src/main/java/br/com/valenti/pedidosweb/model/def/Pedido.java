package br.com.valenti.pedidosweb.model.def;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import br.com.valenti.pedidosweb.model.enumeration.FormaPagamento;
import br.com.valenti.pedidosweb.model.enumeration.StatusPedido;

/**
 *
 * @author Eber Lasso
 */

@Entity
public class Pedido implements Serializable {
	/************************************** PROPRIEDADES ********************************************/

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;
    
	
	@Column(length=100)
	private String observacao;
    
    @NotNull
	@Temporal(TemporalType.DATE)
    private Date dataEntrega;
    
    @NotBlank @NotNull
	@Column(name = "valor_frete",nullable=false,precision=10, scale=2 )
    private BigDecimal valorFrete = BigDecimal.ZERO;
    
    @NotNull
	@Column(name = "valor_desconto",nullable=false,precision=10, scale=2 )
    private BigDecimal valorDesconto = BigDecimal.ZERO;
    
    @NotNull
	@Column(name = "valor_total",nullable=false,precision=10, scale=2 )
    private BigDecimal valorTotal = BigDecimal.ZERO;
    
    @NotNull
    @Enumerated(EnumType.ORDINAL)
    @Column(name="satus_pedido", nullable=false, length=50)
    private StatusPedido status = StatusPedido.ORCAMENTO;
    
    @NotNull @NotBlank
    @Enumerated(EnumType.ORDINAL)
    @Column(name="forma_pgto", nullable=false)
    private FormaPagamento formaPagamento;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name="id_vendedor", nullable=false)
    private Usuario vendedor;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name="pessoa_id", nullable=false)
    private Pessoa cliente;
    
    @NotNull
    @Embedded
    private EnderecoEntrega enderecoEntrega;
    
    @NotNull
    @OneToMany(mappedBy="pedido", cascade=CascadeType.ALL, orphanRemoval=true, fetch = FetchType.LAZY)
    private List<ItemPedido> itensPedidos = new ArrayList();
    
    /************************************** GETS E SETS ********************************************/
    
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public BigDecimal getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(BigDecimal valorFrete) {
        this.valorFrete = valorFrete;
    }

    public BigDecimal getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(BigDecimal valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Usuario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    public EnderecoEntrega getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(EnderecoEntrega enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }
    

    public List<ItemPedido> getItensPedidos() {
        return itensPedidos;
    }

    public void setItensPedidos(List<ItemPedido> itensPedidos) {
        this.itensPedidos = itensPedidos;
    }
    
    @Transient
    public boolean isNovo(){    	
		return getId() == null;    	
    }
    
    @Transient
    public boolean isExistente() {
		return !isNovo();    			
	}
    
    /************************************** hashCode E equals ********************************************/
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Pedido other = (Pedido) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}

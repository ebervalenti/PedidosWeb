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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import br.com.valenti.pedidosweb.model.enumeration.FormaPagamento;
import br.com.valenti.pedidosweb.model.enumeration.StatusPedido;
import br.com.valenti.pedidosweb.security.UsuarioSistema;

/**
 *
 * @author Eber Lasso
 */

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {
	/************************************** PROPRIEDADES ********************************************/

	private static final long serialVersionUID = 1L;
	private Long id;
	private Date dataCriacao;
	private String observacao;
    private Date dataEntrega;
    private BigDecimal valorFrete = BigDecimal.ZERO;
    private BigDecimal valorDesconto = BigDecimal.ZERO;
    private BigDecimal valorTotal = BigDecimal.ZERO;   
    private StatusPedido status = StatusPedido.ORCAMENTO;   
    private FormaPagamento formaPagamento;   
    private Usuario vendedor;   
    private Pessoa cliente;  
    private Endereco enderecoEntrega;   
    private List<ItemPedido> itensPedidos = new ArrayList<ItemPedido>();
    private Usuario usuarioLogado;
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

    @NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column
    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Column(length=100)
    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @NotNull
	@Temporal(TemporalType.DATE)
    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    @NotNull
	@Column(name = "valor_frete",nullable=false,precision=10, scale=2 )
    public BigDecimal getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(BigDecimal valorFrete) {
        this.valorFrete = valorFrete;
    }

    @NotNull
	@Column(name = "valor_desconto",nullable=false,precision=10, scale=2 )
    public BigDecimal getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(BigDecimal valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    @NotNull
	@Column(name = "valor_total",nullable=false,precision=10, scale=2 )
    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="satus_pedido", nullable=false, length=50)
    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="forma_pgto", nullable=false)
    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    @NotNull
    @ManyToOne
    @JoinColumn(name="vendedor_id", nullable=false)
    public Usuario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
    }

    @NotNull 
    @ManyToOne
    @JoinColumn(name="pessoa_id", nullable=false)
    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    @Embedded
    public Endereco getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(Endereco enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }
    

    @NotNull
    @OneToMany(mappedBy="pedido", cascade=CascadeType.ALL, orphanRemoval=true, fetch = FetchType.LAZY)
    public List<ItemPedido> getItensPedidos() {
        return itensPedidos;
    }

    public void setItensPedidos(List<ItemPedido> itensPedidos) {
        this.itensPedidos = itensPedidos;
    }      

    @NotNull
    @OneToOne
    @JoinColumn(name="usuario_id", nullable=false)
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}	
	
	
	@NotNull
    @OneToOne
    @JoinColumn(name="empresa_id", nullable=false)
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	/************************************** MÉTODOS ********************************************/	

	@Transient
    public boolean isNovo(){    	
		return getId() == null;    	
    }
    
    @Transient
    public boolean isExistente() {
		return !isNovo();    			
	}
    
    
    public void recalcularValorTotal() {
		BigDecimal total = BigDecimal.ZERO;
		
		total = total.add(this.getValorFrete()).subtract(this.getValorDesconto()); 
		
		for (ItemPedido item : this.getItensPedidos()) {
			if (item.getProduto() != null && item.getProduto().getId() != null) {
				total = total.add(item.getValorTotal());				
			}			
		}		
			this.setValorTotal(total);
			
	}
    
    @Transient
    public BigDecimal getValorSubTotal(){
    	return this.getValorTotal().subtract(this.getValorFrete()).
    			add(this.getValorDesconto());				
    }
    
    //primeiro produto da lista de todos os itens
    public void adicionarItemVazio() {
    	if (this.isOrcamento()) {	
		Produto produto = new Produto();
				
		ItemPedido item = new ItemPedido();		
		item.setProduto(produto);
		item.setPedido(this);
		
		this.getItensPedidos().add(0,item);	
    	}
	}  
    
    @Transient
    public boolean isOrcamento() {		
		return StatusPedido.ORCAMENTO.equals(this.getStatus());
	}
    
    
    public void removerItemVazio() {
    	ItemPedido primeiroitem  = this.getItensPedidos().get(0);
    	
    	if (primeiroitem != null && primeiroitem.getId() == null) {
			this.getItensPedidos().remove(0);
		}   	
    } 
    
    @Transient
    public boolean isValorNegativo() {    	
    	return this.getValorTotal().compareTo(BigDecimal.ZERO)<0;
    }
    
    @Transient
    public boolean isEmitido() {
    	return StatusPedido.EMITIDO.equals(this.getStatus());    	
    	
    }
    
    @Transient
    public boolean isNaoEmissivel() {    	
    	return !this.isEmissivel();
    }
    
    @Transient
    public boolean isEmissivel() {    	
    	return this.isExistente() && this.isOrcamento();
    }
    
    @Transient
    public boolean isNaoCancelavel() {    	
    	return !this.isCancelavel();
    }
    
    @Transient
	private boolean isCancelavel() {		
		return this.isExistente() && !this.isCancelado();
	}
    
    @Transient
	private boolean isCancelado() {		
		return StatusPedido.CANCELAD0.equals(this.getStatus());
	}
    
    @Transient
    public boolean isNaoAlteravel() {    	
    	return !this.isAlteravel();
    }
    
    @Transient
	private boolean isAlteravel() {		
		return StatusPedido.ORCAMENTO.equals(this.getStatus());
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
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}






}

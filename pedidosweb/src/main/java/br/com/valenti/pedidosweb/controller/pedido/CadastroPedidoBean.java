package br.com.valenti.pedidosweb.controller.pedido;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import br.com.valenti.pedidosweb.controller.events.PedidoAlteradoEvent;
import br.com.valenti.pedidosweb.model.def.Empresa;
import br.com.valenti.pedidosweb.model.def.Endereco;
import br.com.valenti.pedidosweb.model.def.ItemPedido;
import br.com.valenti.pedidosweb.model.def.Pedido;
import br.com.valenti.pedidosweb.model.def.Pessoa;
import br.com.valenti.pedidosweb.model.def.Produto;
import br.com.valenti.pedidosweb.model.def.Usuario;
import br.com.valenti.pedidosweb.model.enumeration.FormaPagamento;
import br.com.valenti.pedidosweb.model.repository.Pessoas;
import br.com.valenti.pedidosweb.model.repository.Produtos;
import br.com.valenti.pedidosweb.model.repository.Usuarios;
import br.com.valenti.pedidosweb.model.repository.filter.PessoaFilter;
import br.com.valenti.pedidosweb.model.repository.filter.ProdutoFilter;
import br.com.valenti.pedidosweb.security.Seguranca;
import br.com.valenti.pedidosweb.services.CadastroPedidoService;
import br.com.valenti.pedidosweb.services.NegocioException;
import br.com.valenti.pedidosweb.util.jsf.FacesUtil;
import br.com.valenti.pedidosweb.validation.SKU;


@Named
@ViewScoped
public class CadastroPedidoBean implements Serializable{
	
	/************************************** PROPRIEDADES ********************************************/	
    
    private static final long serialVersionUID = 1L;
    
    @Produces
    @PedidoEdicao
    private Pedido pedido;
    
    @Inject
    private Usuarios usuarios;
    
    private List<Usuario> vendedores;
    
    @Inject
    private Pessoas clientes;
    
    private PessoaFilter cliente = new PessoaFilter();
	
    @Inject
    private CadastroPedidoService cadastroPedidoService;
    
    private Produto produtoLinhaEditavel;
    
    @Inject
    private Produtos produtos; //repository
    
    private ProdutoFilter produtoFiltro = new ProdutoFilter();
    
    private String sku;
    
    @Inject
    private Seguranca seguranca;
    
    private Empresa empresaPedido;
	
	/************************************** CONSTRUTOR ********************************************/
	
	public CadastroPedidoBean() {
		limpar();	
	}
	
	/************************************** GETS E SETS ********************************************/		
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}	

	public List<Usuario> getVendedores() {
		return vendedores;
	}

	public void setVendedores(List<Usuario> vendedores) {
		this.vendedores = vendedores;
	}	

	public Produto getProdutoLinhaEditavel() {
		return produtoLinhaEditavel;
	}

	public void setProdutoLinhaEditavel(Produto produtoLinhaEditavel) {
		this.produtoLinhaEditavel = produtoLinhaEditavel;
	}

	public ProdutoFilter getProdutoFiltro() {
		return produtoFiltro;
	}

	public void setProdutoFiltro(ProdutoFilter produtoFiltro) {
		this.produtoFiltro = produtoFiltro;
	}	

	@SKU
	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}
	
	public void name() {
		
	}

	/************************************** MÉTODOS ********************************************/	
	public void salvar() {		
		/*método criado para remover o primeiro item vazio do pedido, 
		pois este é o elemento usado na linha de inserção de itens do pedido */
		this.pedido.removerItemVazio();
		
		try {			
			this.pedido.setEmpresa(seguranca.getUsuario().getEmpresa());
			this.pedido.setUsuarioLogado(seguranca.getUsuario());			
			this.pedido = this.cadastroPedidoService.salvar(this.pedido);	
			FacesUtil.addInfoMessage("Pedido salvo com sucesso!.");
		} finally {
			this.pedido.adicionarItemVazio();
		}					
	}
	
	private void limpar(){
		pedido = new Pedido();
		pedido.setEnderecoEntrega(new Endereco());
		empresaPedido = new Empresa();
	}
	
	public void inicializar() {
		if (FacesUtil.isNotPostBack()) {
			this.vendedores = this.usuarios.vendedores();
			
			this.pedido.adicionarItemVazio();
			
			this.recalcularPedido();
		}
			 		
	}

	public List<Pessoa> completarCliente(String nome) {		
		this.cliente.setNome(nome);
		return this.clientes.pesquisar(cliente); 		
	} 	
	
	public FormaPagamento[] getFormaPgto(){
		return FormaPagamento.values();	
	}
	
	//Chama o método de recalcular na classe pedido para atualizar o total do pedido tela.
	public void recalcularPedido(){
		if (this.pedido != null) {			
			this.pedido.recalcularValorTotal();				
		}	
	}
	
	//troca o label da tela de cadastro para edição ou novo pedido	
	public boolean isEditando(){
		return this.pedido.getId()!= null; 	
	}
	
	public List<Produto> completarProduto(String nome){	
		this.produtoFiltro.setNome(nome);
		return this.produtos.pesquisar(produtoFiltro);
		
	}
	
	public void carregarProdutoLinhaEditavel(){
		ItemPedido item = this.pedido.getItensPedidos() .get(0);	
		
		if (this.produtoLinhaEditavel != null) {
			if (this.existeItemComProduto(this.produtoLinhaEditavel)) {
				FacesUtil.addErrorMessage("Jé existe um item com o produto informado.");
				this.produtoLinhaEditavel = null;
			}		
			else{			
				item.setProduto(this.produtoLinhaEditavel);
				item.setValorUnitario(this.produtoLinhaEditavel.getValorUnitario());
				
				this.pedido.adicionarItemVazio();
				this.produtoLinhaEditavel = null;
				this.sku = null;
				
				
				this.pedido.recalcularValorTotal();		
			}
		}
	}
	
	private boolean existeItemComProduto(Produto produtoLinhaEditavel2) {
		boolean existeItem = false;
		
		for (ItemPedido item : this.getPedido().getItensPedidos()) {
			if (produtoLinhaEditavel2.equals(item.getProduto())) {
				existeItem = true;
				break;
			}			
		}
		return existeItem;
	}

	public void carregarProdutoPorSku(){
		if (StringUtils.isNotEmpty(this.sku)) {
			this.produtoLinhaEditavel = this.produtos.porSku(this.sku);			
			this.carregarProdutoLinhaEditavel();			
		}		
	}
	
	public void atualizarQuantidade(ItemPedido item, int linha){
		if (item.getQuantidade() < 1) {
			if (linha == 0) {
				item.setQuantidade(1);
			}
			else{
				this.getPedido().getItensPedidos().remove(linha);
			}
		}	
		this.pedido.recalcularValorTotal();	
	}	
	
	/*
	  este método funciona da seguinte forma:
	  1 -Foi criado um controller de evento para atualizar o pedido com o nome "PedidoAlteradoEvent"
	    1.1 - Este método vai pegar o "pedido" instanciado em "PedidoAlteradoEvent"
      
      2 - a anotação @Observes vai observar quando "PedidoAlteradoEvent event" for chamado passando para 
      a variável "event" o pedido . Esse método vai ser disparado em "EmissaoPedidoBean" 
      no método this.pedidoAlteradoEvent.fire(new PedidoAlteradoEvent(this.pedido));
	 */
	public void pedidoAlterado(@Observes PedidoAlteradoEvent event) {
		this.pedido = event.getPedido();
		
	}
}
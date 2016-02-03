package br.com.valenti.pedidosweb.controller.pedido;

import java.io.Serializable;
import java.util.ArrayList;
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
import br.com.valenti.pedidosweb.model.def.ItemEstoque;
import br.com.valenti.pedidosweb.model.def.ItemPedido;
import br.com.valenti.pedidosweb.model.def.Pedido;
import br.com.valenti.pedidosweb.model.def.Pessoa;
import br.com.valenti.pedidosweb.model.def.Produto;
import br.com.valenti.pedidosweb.model.def.Usuario;
import br.com.valenti.pedidosweb.model.enumeration.FormaPagamento;
import br.com.valenti.pedidosweb.model.repository.Itens_Estoque;
import br.com.valenti.pedidosweb.model.repository.Pessoas;
import br.com.valenti.pedidosweb.model.repository.Produtos;
import br.com.valenti.pedidosweb.model.repository.Usuarios;
import br.com.valenti.pedidosweb.model.repository.filter.Itemestoquefilter;
import br.com.valenti.pedidosweb.model.repository.filter.PessoaFilter;
import br.com.valenti.pedidosweb.model.repository.filter.ProdutoFilter;
import br.com.valenti.pedidosweb.security.Seguranca;
import br.com.valenti.pedidosweb.services.CadastroPedidoService;
import br.com.valenti.pedidosweb.services.Itens_EstoqueService;
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
	
    //@Inject
    //private CadastroPedidoService cadastroPedidoService;
    
    @Inject
    private Itens_EstoqueService cadastroPedidoService;
    
   // private Produto produtoLinhaEditavel;
    
    private ItemEstoque produtoLinhaEditavel;
    
    //@Inject
    //private Produtos produtos; //repository
    
    @Inject
    private Itens_Estoque produtos; //repository
    
    //private ProdutoFilter produtoFiltro = new ProdutoFilter();
    
    private Itemestoquefilter produtoFiltro = new Itemestoquefilter();
    
   // private String sku;
    
    @Inject
    private Seguranca seguranca;
    
    private Empresa empresaPedido;   
	
	/************************************** CONSTRUTOR ********************************************/
	
	public CadastroPedidoBean() {
		limpar();	
	}
	
	/************************************** GETS  ********************************************/		
	public Pedido getPedido() {
		return pedido;
	}


	public List<Usuario> getVendedores() {
		return vendedores;
	}

/*
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
	*/
	
	public ItemEstoque getProdutoLinhaEditavel() {
		return produtoLinhaEditavel;
	}

	public Itens_Estoque getProdutos() {
		return produtos;
	}

	public Itemestoquefilter getProdutoFiltro() {
		return produtoFiltro;
	}
	

	/**************************************  SETS ********************************************/	
	
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}	
	
	
	public void setVendedores(List<Usuario> vendedores) {
		this.vendedores = vendedores;
	}	
	
	public void setProdutoLinhaEditavel(ItemEstoque produtoLinhaEditavel) {
		this.produtoLinhaEditavel = produtoLinhaEditavel;
	}

	public void setProdutos(Itens_Estoque produtos) {
		this.produtos = produtos;
	}

	public void setProdutoFiltro(Itemestoquefilter produtoFiltro) {
		this.produtoFiltro = produtoFiltro;
	}	
	

	/************************************** MÉTODOS ********************************************/	
	public void salvar() {		
		/*método criado para remover o primeiro item vazio do pedido, 
		pois este é o elemento usado na linha de inserção de itens do pedido */
		this.pedido.removerItemVazio();
		
		try {			
			this.pedido.setEmpresa(seguranca.getUsuario().getEmpresa());
			this.pedido.setUsuarioLogado(seguranca.getUsuario());			
			this.pedido = this.cadastroPedidoService.guardarPedido(this.pedido);	
			FacesUtil.addInfoMessage("Pedido no. "+ this.pedido.getId() + ". Salvo com sucesso!.");
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
	
	public List<ItemEstoque> completarProduto(String nome){			
		this.produtoFiltro.setNome(nome);		
		return this.produtos.pesquisar(produtoFiltro);
		
	}
	
	public void carregarProdutoLinhaEditavel(){
		ItemPedido item = this.pedido.getItensPedidos().get(0);	
		
		if (this.produtoLinhaEditavel.getProduto() != null) {
			if (this.existeItemComProduto(this.produtoLinhaEditavel)) {
				FacesUtil.addErrorMessage("Jé existe um item com o produto informado.");
				this.produtoLinhaEditavel = null;
			}		
			else{	
				item.setProduto(this.produtoLinhaEditavel);
				item.getProduto().setProduto(this.produtoLinhaEditavel.getProduto());
				item.setValorUnitario(this.produtoLinhaEditavel.getProduto().getValorUnitario());
				
				this.pedido.adicionarItemVazio();
				this.produtoLinhaEditavel = null;		
				
				
				this.pedido.recalcularValorTotal();		
			}
		}
	}
	
	private boolean existeItemComProduto(ItemEstoque produtoLinhaEditavel2) {
		boolean existeItem = false;
		
		for (ItemPedido item : this.getPedido().getItensPedidos()) {
			if (produtoLinhaEditavel2.getProduto().equals(item.getProduto().getProduto())) {
				existeItem = true;
				break;
			}			
		}
		return existeItem;
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
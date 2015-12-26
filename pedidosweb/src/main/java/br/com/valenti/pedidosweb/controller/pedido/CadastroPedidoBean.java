package br.com.valenti.pedidosweb.controller.pedido;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.valenti.pedidosweb.model.def.EnderecoEntrega;
import br.com.valenti.pedidosweb.model.def.Pedido;
import br.com.valenti.pedidosweb.model.def.Pessoa;
import br.com.valenti.pedidosweb.model.def.Usuario;
import br.com.valenti.pedidosweb.model.enumeration.FormaPagamento;
import br.com.valenti.pedidosweb.model.repository.Pessoas;
import br.com.valenti.pedidosweb.model.repository.Usuarios;
import br.com.valenti.pedidosweb.model.repository.filter.PessoaFilter;
import br.com.valenti.pedidosweb.services.CadastroPedidoServices;
import br.com.valenti.pedidosweb.util.jsf.FacesUtil;


@Named
@ViewScoped
public class CadastroPedidoBean implements Serializable{
	
	/************************************** PROPRIEDADES ********************************************/	
    
    private static final long serialVersionUID = 1L;
    
    private Pedido pedido;
    
    @Inject
    private Usuarios usuarios;
    
    private List<Usuario> vendedores;
    
    @Inject
    private Pessoas clientes;
    
    private PessoaFilter cliente = new PessoaFilter();
	
    @Inject
    private CadastroPedidoServices cadastroPedidoService;
	
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

	/************************************** MÉTODOS ********************************************/	
	public void salvar() {
		this.pedido = this.cadastroPedidoService.salvar(this.pedido);		
		
		FacesUtil.addInfoMessage("Pedido salvo com sucesso!.");
		
		limpar();
	}
	
	private void limpar(){
		pedido = new Pedido();
		pedido.setEnderecoEntrega(new EnderecoEntrega());			
	}
	
	public void inicializar() {
		if (FacesUtil.isNotPostBack()) {
			this.vendedores = this.usuarios.vendedores();			
		}
		 		
	}
	
	public List<Pessoa> completarCliente(String nome) {		
		this.cliente.setNome(nome);
		return this.clientes.pesquisar(cliente); 		
	} 	
	
	public FormaPagamento[] getFormaPgto(){
		return FormaPagamento.values();	
	}
}
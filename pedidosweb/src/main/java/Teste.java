
import java.math.BigDecimal;
import java.time.Period;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.valenti.pedidosweb.model.def.Endereco;
import br.com.valenti.pedidosweb.model.def.EnderecoEntrega;
import br.com.valenti.pedidosweb.model.def.ItemPedido;
import br.com.valenti.pedidosweb.model.def.Pedido;
import br.com.valenti.pedidosweb.model.def.Pessoa;
import br.com.valenti.pedidosweb.model.def.Produto;
import br.com.valenti.pedidosweb.model.def.Usuario;
import br.com.valenti.pedidosweb.model.entity.Cliente;
import br.com.valenti.pedidosweb.model.entity.EnderecoCliente;
import br.com.valenti.pedidosweb.model.enumeration.FormaPagamento;
import br.com.valenti.pedidosweb.model.enumeration.StatusPedido;
import br.com.valenti.pedidosweb.model.enumeration.TipoPessoa;

/**
 *
 * @author Eber Lasso
 */
public class Teste {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PedidosWebPU");
        EntityManager manager = factory.createEntityManager();                 
        
        EntityTransaction trx = manager.getTransaction();
        trx.begin();
        
        Cliente cliente = manager.find(Cliente.class,1L);
        Produto produto = manager.find(Produto.class,1L);
        Usuario vendedor = manager.find(Usuario.class,1L);
        
        EnderecoEntrega enderecoEntrega = new EnderecoEntrega();
        enderecoEntrega.setLogradouro("Rua do Centro");
        enderecoEntrega.setNumero("500");
        enderecoEntrega.setCidade("São Paulo");
        enderecoEntrega.setCep("37260-000");
        enderecoEntrega.setUf("SP");
        
        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setDataCriacao(new Date());
        pedido.setDataEntrega(new Date());
        pedido.setFormaPagamento(FormaPagamento.CARTAO_CREDITO);
        pedido.setObservacao("Entregar a partir das 08:00");
        pedido.setStatus(StatusPedido.ORCAMENTO);
        pedido.setValorDesconto(BigDecimal.ZERO);
        pedido.setValorFrete(BigDecimal.ZERO);
        pedido.setValorTotal(new BigDecimal(5.23));
        pedido.setVendedor(vendedor);
        pedido.setEnderecoEntrega(enderecoEntrega);
        
        ItemPedido itens = new ItemPedido();
        itens.setProduto(produto);
        itens.setQuantidade(10);
        itens.setValorUnitario(new BigDecimal(25.23));
        itens.setPedido(pedido);
        
        pedido.getItensPedidos().add(itens);    
    
        
        manager.persist(pedido);
        
       
        trx.commit();
       
    }

}

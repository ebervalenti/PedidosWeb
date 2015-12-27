import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.valenti.pedidosweb.model.def.Categoria;
import br.com.valenti.pedidosweb.model.def.Produto;

public class CriaProduto {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PedidosWebPU");
        EntityManager manager = factory.createEntityManager();                 
        
        EntityTransaction trx = manager.getTransaction();
        trx.begin();
        
        Produto produto = new Produto();
        Categoria categoria = new Categoria();
        BigDecimal bd1 = new BigDecimal("22.55");
        
        categoria.setId(33L);
        categoria.setDescricao("Blablablabnla");
        
        produto.setCategoria(categoria);
        produto.setNome("Produto Teste");
        produto.setQuantidadeEstoque(22);
        produto.setSku("TTT1234");
        produto.setValorUnitario(bd1); 
        
        //////////////////////////////
        
        trx.commit();

	}

}

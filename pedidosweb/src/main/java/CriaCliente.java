import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.valenti.pedidosweb.model.entity.Cliente;
import br.com.valenti.pedidosweb.model.entity.EnderecoCliente;
import br.com.valenti.pedidosweb.model.enumeration.TipoPessoa;

public class CriaCliente {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PedidosWebPU");
        EntityManager manager = factory.createEntityManager();                 
        
        EntityTransaction trx = manager.getTransaction();
        trx.begin();
        
        
		Cliente cliente = new Cliente();
        cliente.setNome("Eber");
        cliente.setEmail("eber.lasso@gmail.com");
        cliente.setTipo(TipoPessoa.FISICA);
        cliente.setDocRF("123");      
        
        EnderecoCliente enderCli = new EnderecoCliente();
        enderCli.setCep("123");
        enderCli.setCidade("Perdões");
        enderCli.setComplemento("Casa");
        enderCli.setLogradouro("Laura Toledo de vilela");
        enderCli.setNumero("55");
        enderCli.setUf("MG");
        enderCli.setPessoa(cliente); 
        
        cliente.getEnderecos().add(enderCli);     
        
        trx.commit();
	}

}

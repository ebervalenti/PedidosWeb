/**
 * 
 */
package br.com.valenti.pedidosweb.util.jpa;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**  Criado por: Eber Lasso  **/

@Interceptor
@Transacional
public class TransacionalInterceptor implements Serializable {
	/************************************** PROPRIEDADES ********************************************/
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	/************************************** MÉTODOS ********************************************/

	@AroundInvoke
	public Object invoke(InvocationContext context) throws Exception{
		EntityTransaction trx = manager.getTransaction();
		boolean criador = false;
		
		try {
			if (!trx.isActive()) {
				// truque para fazer rollback no que já passou
				// (senão, um futuro commit, confirmaria até mesmo operações sem transação)
				trx.begin();
				trx.rollback();
				
				// agora sim inicia a transação
				trx.begin();
				criador = true;
			}	
			return context.proceed();
		} catch (Exception e) {
			if (trx != null && criador) {
				trx.rollback();			
			}			
			System.out.println("Erro em: TransacionalInterceptor/public Object invoke(InvocationContext context) -  Message: "+
					e.getMessage());			
			throw e;
		}finally{
			if (trx != null && trx.isActive() && criador) {
				trx.commit();				
			}			
		}		
	}
	
}

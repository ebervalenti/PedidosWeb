package br.com.valenti.pedidosweb.security;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import br.com.valenti.pedidosweb.model.def.Usuario;

@Named
@RequestScoped
public class Seguranca {
	/************************************** PROPRIEDADES ********************************************/
	 @Inject
	 private ExternalContext externalcontext;
	/************************************** CONSTRUTOR ********************************************/

	/************************************** GETS ********************************************/

	/************************************** SETS ********************************************/

	/************************************** MÉTODOS ********************************************/
	public Usuario getUsuario() {
		Usuario usuario = null;
		
		UsuarioSistema usuarioLogado = getUsuarioLogado();
		
		if (usuarioLogado != null) {
			usuario = usuarioLogado.getUsuario();
		}
		
		return usuario;
	}

	private UsuarioSistema getUsuarioLogado() {
		UsuarioSistema usuario = null;
		
		UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) 
				FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
		
		if (auth != null && auth.getPrincipal() != null) {
			usuario = (UsuarioSistema) auth.getPrincipal();
		}
		
		return usuario;
	}
	
	//HABILITA OU DESABILITA OS BOTÕES DE ACORDO COM O GRUPO DE USUÁRIO
	public boolean isEmitirPedido_Permitido(){
		/* Interpretando esse código seria: o externalcontext que está logado (isUserInRole) 
		 * é do tipo ADMINISTRADORES ou ?
		*/
		return externalcontext.isUserInRole("ADMINISTRADORES") ||
				externalcontext.isUserInRole("VENDEDORES")||
				externalcontext.isUserInRole("MASTER");
		
	}
	
	//HABILITA OU DESABILITA OS BOTÕES DE ACORDO COM O GRUPO DE USUÁRIO
		public boolean isCancelarPedido_Permitido(){
			/* Interpretando esse código seria: o externalcontext que está logado (isUserInRole) 
			 * é do tipo ADMINISTRADORES ou ?
			*/
			return externalcontext.isUserInRole("ADMINISTRADORES") ||
					externalcontext.isUserInRole("VENDEDORES")||
					externalcontext.isUserInRole("MASTER");
			
		}

	/************************************** hashCode E equals ********************************************/

}

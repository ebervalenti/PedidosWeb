package br.com.valenti.pedidosweb.controller.login;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.valenti.pedidosweb.util.jsf.FacesUtil;

@Named
@SessionScoped
public class LoginBean implements Serializable  {
	/************************************** PROPRIEDADES ********************************************/
	private static final long serialVersionUID = 1L;
	
	@Inject
	private FacesContext facesContext;
	
	// Objeto que irá repesntar a requisição Servelet 
	@Inject
	private HttpServletRequest request;
	
	// Objeto que irá repesntar a resposta  Servelet que é a resposta para o cliente
	@Inject
	private HttpServletResponse response;
	
	private String username;

	/************************************** CONSTRUTOR ********************************************/

	/************************************** GETS ********************************************/
	public String getUsername() {
		return username;
	}
	/************************************** SETS ********************************************/
	public void setUsername(String username) {
		this.username = username;
	}	
	/************************************** MÉTODOS ********************************************/
	public void login() throws ServletException, IOException {
		/* 
		 * esta é a URL para login do security no Spring, mas como o nosso form de login é em JSF 
		 *não tem como apontar diretamente então jogamos a requisição para o Bean que despachará a 
		 *requisição ao Spring
		 */
		RequestDispatcher dispatcher = request.getRequestDispatcher("/j_spring_security_check");
		
		 //Despachando a requisição		
		dispatcher.forward(request, response);		
		
		/* Para o contexto encerra ou interrompe  o ciclo de vida pois já foi
		   dispachada a requisição
		   */
		facesContext.responseComplete();
	}
	
	public void preRender() {
		if ("true".equals(request.getParameter("invalid"))) {
			FacesUtil.addErrorMessage("Usuário ou senha inválido!");
		}
	}
	
	

	/************************************** hashCode E equals ********************************************/

}

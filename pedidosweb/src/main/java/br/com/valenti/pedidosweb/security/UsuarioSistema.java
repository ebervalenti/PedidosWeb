package br.com.valenti.pedidosweb.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import br.com.valenti.pedidosweb.model.def.Usuario;

public class UsuarioSistema extends User {

	/************************************** PROPRIEDADES ********************************************/
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	/************************************** CONSTRUTOR ********************************************/


	/************************************** GETS ********************************************/
	public Usuario getUsuario() {
		return usuario;
	}

	/************************************** SETS ********************************************/

	/************************************** MÉTODOS ********************************************/
	public UsuarioSistema(Usuario usuario, Collection<? extends GrantedAuthority> authorities) {
		super(usuario.getUserName(), usuario.getSenha(), authorities);	
		this.usuario = usuario;
	}

	/************************************** hashCode E equals ********************************************/

}

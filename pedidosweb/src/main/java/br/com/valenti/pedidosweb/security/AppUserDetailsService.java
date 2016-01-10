package br.com.valenti.pedidosweb.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.valenti.pedidosweb.model.def.Grupo;
import br.com.valenti.pedidosweb.model.def.Usuario;
import br.com.valenti.pedidosweb.model.repository.Usuarios;
import br.com.valenti.pedidosweb.util.cdi.CDIServiceLocator;

public class AppUserDetailsService implements UserDetailsService {

	/************************************** PROPRIEDADES ********************************************/

	/************************************** CONSTRUTOR ********************************************/

	/************************************** GETS ********************************************/

	/************************************** SETS ********************************************/

	/************************************** MÉTODOS ********************************************/
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {		
		Usuarios usuarios = CDIServiceLocator.getBean(Usuarios.class);
		Usuario usuario = usuarios.porUserName(username);
		
		UsuarioSistema user = null;
		
		if (usuario != null) {
			user = new UsuarioSistema(usuario, getGrupos(usuario));
		}		
		return user;
	}

	private Collection<? extends GrantedAuthority> getGrupos(Usuario usuario) {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		
		for (Grupo grupo : usuario.getGrupos()) {
			authorities.add(new SimpleGrantedAuthority(grupo.getNome().toUpperCase()));
		}
		
		return authorities;
	}

	/************************************** hashCode E equals ********************************************/

}

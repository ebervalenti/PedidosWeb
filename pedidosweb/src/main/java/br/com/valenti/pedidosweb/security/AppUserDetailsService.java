package br.com.valenti.pedidosweb.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.valenti.pedidosweb.model.def.Empresa;
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
		UsuarioSistema user = null;
		
		Usuario usuario = new Usuario();
		
		
		if (username.equals("master")) {
			Grupo grupo = new Grupo();
			grupo.setId(new Long(999999));
			grupo.setNome("Master");
			
			Empresa empresa = new Empresa();
			empresa.setId(new Long(999999));
			
			usuario.setId(new Long(999999));
			usuario.setUserName(username);
			usuario.setSenha("b59c67bf196a4758191e42f76670ceba");
			usuario.getGrupos().add(grupo);
			usuario.setNome("Master");
			usuario.setEmpresa(empresa);
			
			user = new UsuarioSistema(usuario, getGrupos(usuario));
		}
		else{
			usuario = usuarios.porUserName(username);			
			if (usuario != null) {
				user = new UsuarioSistema(usuario, getGrupos(usuario));
			}				
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

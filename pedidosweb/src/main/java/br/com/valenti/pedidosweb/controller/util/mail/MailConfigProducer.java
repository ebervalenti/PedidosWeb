package br.com.valenti.pedidosweb.controller.util.mail;

import java.io.IOException;
import java.util.Properties;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import com.outjected.email.api.SessionConfig;
import com.outjected.email.impl.SimpleMailConfig;

public class MailConfigProducer {
	
	/************************************** PROPRIEDADES ********************************************/

	/************************************** CONSTRUTOR ********************************************/

	/************************************** GETS ********************************************/

	/************************************** SETS ********************************************/

	/************************************** MÉTODOS *******************************************/
	  
	@Produces
	@ApplicationScoped 
	public SessionConfig getMailConfig() throws IOException{
		Properties propriedadesDoEmail = new Properties();
		propriedadesDoEmail.load(getClass().getResourceAsStream("/mail.properties"));		
																
		SimpleMailConfig config = new SimpleMailConfig();
		config.setServerHost(propriedadesDoEmail.getProperty("mail.server.host"));
		config.setServerPort(Integer.parseInt(propriedadesDoEmail.getProperty("mail.server.port")));
		config.setEnableSsl(Boolean.parseBoolean(propriedadesDoEmail.getProperty("mail.enable.ssl")));
		config.setAuth(Boolean.parseBoolean(propriedadesDoEmail.getProperty("mail.auth")));
		config.setUsername(propriedadesDoEmail.getProperty("mail.username"));
		config.setPassword(propriedadesDoEmail.getProperty("mail.password"));		
		return config;		
	}

	/************************************** hashCode E equals ********************************************/

}

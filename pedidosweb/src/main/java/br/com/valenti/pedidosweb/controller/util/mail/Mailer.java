package br.com.valenti.pedidosweb.controller.util.mail;

import java.io.Serializable;

import javax.inject.Inject;

import com.outjected.email.api.MailMessage;
import com.outjected.email.api.SessionConfig;
import com.outjected.email.impl.MailMessageImpl;

public class Mailer implements Serializable {

	/************************************** PROPRIEDADES ********************************************/
	private static final long serialVersionUID = 1L;
	
	@Inject
	private SessionConfig config;

	/************************************** CONSTRUTOR ********************************************/

	/************************************** GETS ********************************************/

	/************************************** SETS ********************************************/

	/************************************** MÉTODOS ********************************************/
	public MailMessage novaMensagem(){
		return new MailMessageImpl(this.config);
		
	}

	/************************************** hashCode E equals ********************************************/

}

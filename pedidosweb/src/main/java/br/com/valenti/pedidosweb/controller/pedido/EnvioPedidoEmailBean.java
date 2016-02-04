package br.com.valenti.pedidosweb.controller.pedido;

import java.io.Serializable;
import java.util.Locale;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.velocity.tools.generic.NumberTool;

import com.outjected.email.api.MailMessage;
import com.outjected.email.impl.templating.velocity.VelocityTemplate;

import br.com.valenti.pedidosweb.controller.util.mail.Mailer;
import br.com.valenti.pedidosweb.model.def.Pedido;
import br.com.valenti.pedidosweb.util.jsf.FacesUtil;

@Named
@RequestScoped
public class EnvioPedidoEmailBean implements Serializable{

	/************************************** PROPRIEDADES ********************************************/
	private static final long serialVersionUID = 1L;	
	
	@Inject
	@PedidoEdicao
	private Pedido pedido;
	
	@Inject
	private Mailer mailer; 

	/************************************** CONSTRUTOR ********************************************/

	/************************************** GETS ********************************************/

	/************************************** SETS ********************************************/

	/************************************** MÉTODOS ********************************************/
	private void enviarPedido() { 
		MailMessage message = mailer.novaMensagem();
		
		message.to(this.pedido.getCliente().getEmail())
			.subject("Pedido no. " + this.pedido.getId())
			.bodyHtml(new VelocityTemplate(getClass().getResourceAsStream("/emails/templateEmailPedido.template")))
			.put("pedido", this.pedido)
			.put("numberTool", new NumberTool())
			.put("locale", new Locale("pt","BR"))
			.send();
		
		FacesUtil.addInfoMessage("Pedido enviado por e-mail com sucesso!");
		
		
		
	}

	/************************************** hashCode E equals ********************************************/

}

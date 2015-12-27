package br.com.valenti.pedidosweb.controller.util;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@ManagedBean(name="dataHora")
@ViewScoped
public class DataHora implements Serializable {	
	/************************************** PROPRIEDADES ********************************************/
	private static final long serialVersionUID = 1L;	
	
	private Date dataAtual = new Date();

	/************************************** CONSTRUTOR ********************************************/

	/************************************** GETS ********************************************/

	/************************************** SETS ********************************************/

	/************************************** MÉTODOS ********************************************/
	public void relogio(){
        dataAtual = Calendar.getInstance(new Locale("BR")).getTime();
    }

}

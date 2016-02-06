package br.com.valenti.pedidosweb.model.def;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.valenti.pedidosweb.model.enumeration.ClassePessoa;
import br.com.valenti.pedidosweb.model.enumeration.FisicaJuridica;

@Entity
@Table(name = "cliente")
public class Cliente extends Pessoa implements Serializable {

	/************************************** PROPRIEDADES ********************************************/
	private static final long serialVersionUID = 1L;	

	/************************************** CONSTRUTOR ********************************************/

	/************************************** GETS ********************************************/	

	/************************************** SETS ********************************************/	
	
	/************************************** MÉTODOS ********************************************/
	@Transient
	@Override
	public ClassePessoa getClasse() {		
		return super.getClasse();
	}
	
	@Transient
	@Override
	public void setClasse(ClassePessoa classe) {		
		super.setClasse(classe.CLIENTE);
	}
	
	@Transient
    public boolean isNovo(){    	
		return getId() == null;    	
    }
    
    @Transient
    public boolean isExistente() {
		return !isNovo();    			
	}
    
    @Transient
    public void atualizaCadastroFisicaJuridica(FisicaJuridica fj) {
    	this.setFj(fj);				
	}
    
    

	
	/************************************** hashCode E equals ********************************************/
	
    
    
}

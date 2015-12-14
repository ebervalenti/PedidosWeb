package br.com.valenti.pedidosweb.model.def;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Eber Lasso
 */
@Entity
public class Grupo implements Serializable {
	/************************************** PROPRIEDADES ********************************************/

	private static final long serialVersionUID = 1L;	
    
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    
	@Column(length=60)
	private String nome;
    
	@Column(length=100)
	private String descricao;

	/************************************** GETS E SETS ********************************************/
   
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /************************************** hashCode E equals ********************************************/
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Grupo other = (Grupo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    

}

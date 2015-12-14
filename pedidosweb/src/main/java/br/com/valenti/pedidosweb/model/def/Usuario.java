package br.com.valenti.pedidosweb.model.def;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Eber Lasso
 */

@Entity
public class Usuario implements Serializable{
	/************************************** PROPRIEDADES ********************************************/

	private static final long serialVersionUID = 1L;	
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    
    @Column(length=100)
    private String nome;
    
    @Column(length=60)
    private String email;
    
    @Column(length=8)
    private String senha;
    
    @ManyToMany(cascade = CascadeType.ALL)	
    private List<Grupo> grupos = new ArrayList();
    
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }
    
    /************************************** hashCode E equals ********************************************/

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
	

}

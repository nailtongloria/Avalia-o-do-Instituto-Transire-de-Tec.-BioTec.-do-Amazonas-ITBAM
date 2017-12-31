/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author nailton viana gloria
 */
@Entity
public class Loja implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String numeroFilial;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Bairro bairro;

    public Loja() {
    }

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

    public String getNumeroFilial() {
        return numeroFilial;
    }

    public void setNumeroFilial(String numeroFilial) {
        this.numeroFilial = numeroFilial;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    @Override
    public String toString() {
        return id + " " + nome + " " + numeroFilial + " " + bairro;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 89 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 89 * hash + (this.numeroFilial != null ? this.numeroFilial.hashCode() : 0);
        hash = 89 * hash + (this.bairro != null ? this.bairro.hashCode() : 0);
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
        final Loja other = (Loja) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.numeroFilial == null) ? (other.numeroFilial != null) : !this.numeroFilial.equals(other.numeroFilial)) {
            return false;
        }
        if (this.bairro != other.bairro && (this.bairro == null || !this.bairro.equals(other.bairro))) {
            return false;
        }
        return true;
    }

}

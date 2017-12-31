/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.Arrays;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Administrador
 */
@Entity
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    @NotNull(message = "O nome  não pode ser NULO")

    @Length(min = 5, max = 80)
    private String nome;
    @NotNull(message = "O tipo não pode ser nulo")
    private String tipo;
    @NotNull(message = "a marca não pode ser nula")
    @Length(min = 5, max = 80)
    private String marca;
    @NotNull(message = "a quantidade não pode ser nula")

    @Min(value = 1, message = " Minimo uma Peça")
    private Double quantidade;
    @NotNull(message = "o valor nao pode ser nulo")
    @Min(value = 2, message = "o valor tem que ter 2 digitos")

    private Double valor;
    @Lob
    private byte[] foto;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Loja loja;

    @NotNull(message = "O tecido nao pode ser Nulo")
    private String tipoTecido;
    @Transient
    private StreamedContent imagem;

    public Produto() {
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public String getTipoTecido() {
        return tipoTecido;
    }

    public void setTipoTecido(String tipoTecido) {
        this.tipoTecido = tipoTecido;
    }

    
    public StreamedContent getImagem() {
        if (this.getFoto() != null) {
            return new DefaultStreamedContent(new ByteArrayInputStream(this.getFoto()), "");
        } else {
            return new DefaultStreamedContent();
        }
    }

    @Override
    public String toString() {
        return nome + " " + tipo + " " + marca + " " + quantidade;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 79 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 79 * hash + (this.tipo != null ? this.tipo.hashCode() : 0);
        hash = 79 * hash + (this.marca != null ? this.marca.hashCode() : 0);
        hash = 79 * hash + (this.quantidade != null ? this.quantidade.hashCode() : 0);
        hash = 79 * hash + (this.valor != null ? this.valor.hashCode() : 0);
        hash = 79 * hash + (this.loja != null ? this.loja.hashCode() : 0);
        hash = 79 * hash + (this.tipoTecido != null ? this.tipoTecido.hashCode() : 0);
        hash = 79 * hash + (this.imagem != null ? this.imagem.hashCode() : 0);
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
        final Produto other = (Produto) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.tipo == null) ? (other.tipo != null) : !this.tipo.equals(other.tipo)) {
            return false;
        }
        if ((this.marca == null) ? (other.marca != null) : !this.marca.equals(other.marca)) {
            return false;
        }
        if (this.quantidade != other.quantidade && (this.quantidade == null || !this.quantidade.equals(other.quantidade))) {
            return false;
        }
        if (this.valor != other.valor && (this.valor == null || !this.valor.equals(other.valor))) {
            return false;
        }
        if (this.loja != other.loja && (this.loja == null || !this.loja.equals(other.loja))) {
            return false;
        }
        if ((this.tipoTecido == null) ? (other.tipoTecido != null) : !this.tipoTecido.equals(other.tipoTecido)) {
            return false;
        }
        if (this.imagem != other.imagem && (this.imagem == null || !this.imagem.equals(other.imagem))) {
            return false;
        }
        return true;
    }

  
    

}


package com.ws.rodrigo.modelo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "endereco")
public class Endereco implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Integer id;
    
    @XmlElement(required = true)
    @NotNull
    private String logradouro;
    
    @XmlElement(required = true)
    @NotNull
    private long numero;
    
    @XmlElement(required = true)
    @NotNull
    private String bairro;
    
    @MapsId
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id", nullable = true, insertable = true, updatable = true)  
    @OneToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)  
    @XmlTransient
    private Pessoa pessoa;

    public Integer getId() {
        return id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    

    public String getLogradouro() {
        return logradouro;
    }

    public long getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }
    
    
    
    
}

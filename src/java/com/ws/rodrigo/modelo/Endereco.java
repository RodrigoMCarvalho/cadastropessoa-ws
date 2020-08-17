
package com.ws.rodrigo.modelo;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Embeddable
public class Endereco implements Serializable {
    
    @XmlElement(required = true)
    @NotNull
    private String logradouro;
    
    @XmlElement(required = true)
    @NotNull
    private long numero;
    
    @XmlElement(required = true)
    @NotNull
    private String bairro;

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
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

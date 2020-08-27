package com.ws.rodrigo.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "token")
@XmlAccessorType(XmlAccessType.FIELD)
public class TokenUsuario {
    
    @XmlElement(required = true)
    private String token;
    
    @XmlElement(required = true)
    private String codigo;

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    
    
}

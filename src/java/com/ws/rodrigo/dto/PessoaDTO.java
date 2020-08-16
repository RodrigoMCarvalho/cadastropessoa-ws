package com.ws.rodrigo.dto;

import com.ws.rodrigo.modelo.Endereco;
import com.ws.rodrigo.modelo.Sexo;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PessoaDTO {
    
    @XmlElement(required = true)
    private String nome;
    
    @XmlElement(required = true)
    private String email;
    
    @XmlElement(required = true)
    private Sexo sexo;
    
    @XmlElement(required = true)
    private Endereco endereco;

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

    public Sexo getSexo() {
        return sexo;
    }

    public Endereco getEndereco() {
        return endereco;
    }
    
    
    
}

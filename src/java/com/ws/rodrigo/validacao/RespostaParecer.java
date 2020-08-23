package com.ws.rodrigo.validacao;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RespostaParecer {
  
    @XmlElement
    private TipoResposta tipo;
    
    @XmlElement
    private String mensagem;

    public RespostaParecer() {
    }
    
    public RespostaParecer(TipoResposta tipo, String mensagem) {
        this.tipo = tipo;
        this.mensagem = mensagem;
    }

    public TipoResposta getTipo() {
        return tipo;
    }

    public void setTipo(TipoResposta tipo) {
        this.tipo = tipo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    
  
}

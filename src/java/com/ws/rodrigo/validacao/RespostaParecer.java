package com.ws.rodrigo.validacao;

import com.ws.rodrigo.dto.ErroDto;
import java.util.List;
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
    
    @XmlElement(name = "ListaErros")
    private List<String> erro;

    public RespostaParecer() {
    }
    
    public RespostaParecer(TipoResposta tipo, String mensagem) {
        this.tipo = tipo;
        this.mensagem = mensagem;
    }

    public RespostaParecer(TipoResposta tipo, List<String> erro) {
        this.tipo = tipo;
        this.erro = erro;
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

    public List<String> getErro() {
        return erro;
    }

    public void setErro(List<String> erro) {
        this.erro = erro;
    }

}

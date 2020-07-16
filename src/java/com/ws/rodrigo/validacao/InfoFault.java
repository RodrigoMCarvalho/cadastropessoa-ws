package com.ws.rodrigo.validacao;

import com.ws.rodrigo.util.DateUtil;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
public class InfoFault {
    
    @XmlJavaTypeAdapter(DateUtil.class)
    private Date dataErro;
    private String mensagem;

    public InfoFault(String mensagem, Date dataErro) {
        this.mensagem = mensagem;
        this.dataErro = dataErro;
    }

    InfoFault() {
    }
}

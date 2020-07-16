package com.ws.rodrigo.validacao;

import java.util.Date;
import javax.xml.ws.WebFault;

@WebFault(name = "MensagemFault")
public class NotFoundExpection extends Exception{
    
    public NotFoundExpection(String mensagem) {
        super(mensagem);
    }
    
    public InfoFault getFaultInfo() {
        return new InfoFault("ID invalido" , new Date());
    }

}

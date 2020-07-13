package com.ws.rodrigo.servicos;

import com.ws.rodrigo.dao.PessoaDAO;
import com.ws.rodrigo.modelo.Pessoa;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

@WebService
public class ServicoPessoa {

    @EJB
    private PessoaDAO dao;

    public ServicoPessoa() {
    }

    @WebMethod
    public List<Pessoa> listaPessoas() {
        return dao.getLista();
    }

    @WebMethod
    public Pessoa inserir(@WebParam(name = "pessoa") @XmlElement(required = true) Pessoa pessoa) {
        return dao.inserir(pessoa);
    }

    @WebMethod
    public Pessoa alterar(@WebParam(name = "pessoa") @XmlElement(required = true) Pessoa pessoa) {
        return dao.alterar(pessoa);
    }

    @WebMethod
    public boolean remover(@WebParam(name = "id") @XmlElement(required = true) Integer id) {
        return dao.remover(id);
    }
}

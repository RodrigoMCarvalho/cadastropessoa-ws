package com.ws.rodrigo.servicos;

import com.ws.rodrigo.dao.PessoaDAO;
import com.ws.rodrigo.dto.PessoaDTO;
import com.ws.rodrigo.modelo.Pessoa;
import com.ws.rodrigo.validacao.NotFoundExpection;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.ws.ResponseWrapper;

@WebService
public class ServicoPessoa {

    @EJB
    private PessoaDAO dao;

    public ServicoPessoa() {
    }

    @WebMethod(operationName = "ObterListaDePessoas")
    @ResponseWrapper(localName = "ListaDePessoas")
    @WebResult(name = "Pessoa")
    public List<Pessoa> listaPessoas() {
        return dao.getLista();
    }
    
    @WebMethod(operationName = "BuscaPorId")
    @WebResult(name = "BuscaPorId")
    public Pessoa buscaPorId(@WebParam(name = "id") @XmlElement(required = true) Integer id) throws NotFoundExpection {
        return dao.buscaPorId(id);
    }
    
    @WebMethod(operationName = "BuscaPorNome")
    @WebResult(name = "BuscaPorNome")
    public List<Pessoa> buscaPorNome(@WebParam(name = "nome") @XmlElement(required = true) String nome) throws NotFoundExpection {
        return dao.BuscaPorNome(nome);
    }

    @WebMethod(operationName = "CadastrarPessoa")
    @WebResult(name = "CadastrarPessoa")
    @ResponseWrapper(localName = "CadastramentoPessoa")
    public Pessoa inserir(@WebParam(name = "pessoa") @XmlElement(required = true) PessoaDTO pessoaDTO) {
        return dao.inserir(pessoaDTO);
    }

    @WebMethod(operationName = "AlterarPessoa")
    @WebResult(name = "AlterarPessoa")
    @ResponseWrapper(localName = "AlteracaoPessoa")
    public Pessoa alterar(@WebParam(name = "pessoa") @XmlElement(required = true) Pessoa pessoa) {
        return dao.alterar(pessoa);
    }

    @WebMethod(operationName = "RemoverPessoa")
    @WebResult(name = "RemoverPessoa")
    @ResponseWrapper(localName = "RemocaoPessoa")
    public boolean remover(@WebParam(name = "id") @XmlElement(required = true) Integer id) throws NotFoundExpection {
        return dao.remover(id);
    }
    
}

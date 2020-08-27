package com.ws.rodrigo.servicos;

import com.ws.rodrigo.dao.ParecerDAO;
import com.ws.rodrigo.dao.PessoaDAO;
import com.ws.rodrigo.dto.PessoaDTO;
import com.ws.rodrigo.modelo.Parecer;
import com.ws.rodrigo.modelo.Pessoa;
import com.ws.rodrigo.modelo.TokenUsuario;
import com.ws.rodrigo.validacao.NotFoundExpection;
import com.ws.rodrigo.validacao.RespostaParecer;
import com.ws.rodrigo.validacao.TipoResposta;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.ws.ResponseWrapper;

@WebService(serviceName = "ServicoPessoaWS")
/*@SOAPBinding(style = SOAPBinding.Style.DOCUMENT,
        use = SOAPBinding.Use.LITERAL,
        parameterStyle = SOAPBinding.ParameterStyle.BARE) Problemas devido a interface List  */
public class ServicoPessoa {

    @EJB
    private PessoaDAO dao;
    
    @EJB
    private ParecerDAO parecerDao;
    
    private List<String> erros = new ArrayList<>();

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
        return dao.buscaPorNome(nome);
    }

    @WebMethod(operationName = "CadastrarPessoa")
    @WebResult(name = "CadastrarPessoa")
    @ResponseWrapper(localName = "CadastramentoPessoa")
    //@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
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
    
    @WebMethod(operationName = "GerarParacer")
    public RespostaParecer gerarParecer(@WebParam(name = "parecer") Parecer parecer) {
        parecerDao.inserir(parecer);
        return new RespostaParecer(TipoResposta.SUCESSO, "Parecer gerado com sucesso");
    }
    
    @WebMethod(operationName = "BuscarParacerPorId")
    @WebResult(name = "Resposta")
    public RespostaParecer buscarParecerPorId(@WebParam(name="tokenUsuario", header=true) TokenUsuario token, 
                                              @WebParam(name = "idParecer") Long idParecer) throws NotFoundExpection {
        erros = new ArrayList<>();
        Parecer parecer = parecerDao.buscaPorId(idParecer);
        if(!token.getToken().equalsIgnoreCase(parecer.getChave())) {
            erros.add("Token: " + token.getToken() + " inválido.");
        }
        if(!token.getCodigo().equalsIgnoreCase(parecer.getDescricao())){
            erros.add("Código: " + token.getCodigo() + " inválida.");
        }
        
        if(!erros.isEmpty()) {
            return new RespostaParecer(TipoResposta.ERRO, erros);
        }
        return new RespostaParecer(TipoResposta.SUCESSO, "Parecer enviado com sucesso!");
    }
    
    @WebMethod(operationName = "BuscarParacer")
    @ResponseWrapper(localName = "ListaDePareceres")
    @WebResult(name = "Pareceres")
    public List<Parecer> buscarParecer() {
        return parecerDao.getListParecer();
    }

    
    
}

package com.ws.rodrigo.dao;

import com.ws.rodrigo.dto.PessoaDTO;
import com.ws.rodrigo.modelo.Pessoa;
import com.ws.rodrigo.validacao.NotFoundExpection;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PessoaDAO implements Serializable {
    
    private List<Pessoa> lista;

    @PersistenceContext(unitName = "ServicoPessoaPU")
    private EntityManager em;

    public PessoaDAO() {
    }

    public Pessoa inserir(PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa(pessoaDTO);
        em.persist(pessoa);
        return pessoa;
    }

    public Pessoa alterar(Pessoa pessoa) {
        em.merge(pessoa);
        return pessoa;
    }
    
    public Pessoa buscaPorId(Integer id) throws NotFoundExpection {
        Pessoa pessoa = em.find(Pessoa.class, id);
        if(pessoa == null) {
            throw new NotFoundExpection("Não encontrado");
        }
        return pessoa;
    }
    
    public List<Pessoa> buscaPorNome(String nome) throws NotFoundExpection {
        List<Pessoa> resultado = em.createQuery("from Pessoa p where lower(p.nome) like lower('%" + nome + "%')").getResultList();
        resultado.forEach(p -> System.out.println(p.getNome()));
        if(resultado.isEmpty()) {
            throw new NotFoundExpection("Não foram localizados dados para a sua busca");
        }
        return resultado;
    }

    public boolean remover(Integer id) throws NotFoundExpection {
        buscaPorId(id);
        try {
            Pessoa pessoa = em.find(Pessoa.class, id);
            em.remove(pessoa);
            return true;
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return false;
        }
    }

    public List<Pessoa> getLista() {
        return em.createQuery("from Pessoa order by id").getResultList();
    }
    
     public void setLista(List<Pessoa> lista) {
        this.lista = lista;
    }

}

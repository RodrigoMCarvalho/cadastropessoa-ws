package com.ws.rodrigo.dao;

import com.ws.rodrigo.dto.PessoaDTO;
import com.ws.rodrigo.modelo.Pessoa;
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
    
    public Pessoa buscaPorId(Integer id) {
        return em.find(Pessoa.class, id);
    }

    public boolean remover(Integer id) {
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

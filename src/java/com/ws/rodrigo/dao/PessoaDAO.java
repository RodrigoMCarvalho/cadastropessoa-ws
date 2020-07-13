package com.ws.rodrigo.dao;

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

    public Pessoa inserir(Pessoa pessoa) {
        em.persist(pessoa);
        return pessoa;
    }

    public Pessoa alterar(Pessoa pessoa) {
        em.merge(pessoa);
        return pessoa;
    }

    public boolean remover(Integer id) {
        try {
            em.find(Pessoa.class, id);
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

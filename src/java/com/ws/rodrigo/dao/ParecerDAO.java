package com.ws.rodrigo.dao;

import com.ws.rodrigo.modelo.Parecer;
import com.ws.rodrigo.modelo.Pessoa;
import com.ws.rodrigo.validacao.NotFoundExpection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ParecerDAO {
    
    List<Parecer> listParecer;
    
    @PersistenceContext(unitName = "ServicoPessoaPU")
    private EntityManager em;
    
    public Parecer inserir(Parecer parecer) {
        em.persist(parecer);
        return parecer;
    }

    public List<Parecer> getListParecer() {
        return em.createQuery("from Parecer order by id").getResultList();
    }
    
     public Parecer buscaPorId(Long id) throws NotFoundExpection {
        Parecer parecer = em.find(Parecer.class, id);
        if(parecer == null) {
            throw new NotFoundExpection("Não encontrado");
        }
        return parecer;
    }
    
    
    
}

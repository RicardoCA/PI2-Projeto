/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import models.Modalidade;
import models.Usuario;
import util.JpaUtil;

/**
 *
 * @author Ricardo
 */
public class ModalidadeDaoJpa implements ModalidadeDao{
    
    @Override
    public void salvar(Modalidade m) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        if (m.getId() == null) {
            em.persist(m);
        } else {
            em.merge(m);
        }
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void remover(Modalidade m) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();        
        em.remove(em.merge(m));
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Modalidade buscarPorId(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        Modalidade modalidade = em.find(Modalidade.class, id);
        em.close();
        return (modalidade);
    }
    
    

    @Override
    public List<Modalidade> listar() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Modalidade> listaModalidades = em.createQuery("SELECT m FROM Modalidade m").getResultList();
        em.close();
        return (listaModalidades);
    }
    
    
   
    
    
    
}

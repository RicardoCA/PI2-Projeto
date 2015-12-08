/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import models.*;
import models.Usuario;
import util.JpaUtil;

/**
 *
 * @author Ricardo
 */
public class AulaDaoJpa implements AulaDao{
    
    @Override
    public void salvar(Aula a) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        if (a.getId() == null) {
            em.persist(a);
        } else {
            em.merge(a);
        }
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void remover(Aula a) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();        
        em.remove(em.merge(a));
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Aula buscarPorId(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        Aula aula = em.find(Aula.class, id);
        em.close();
        return (aula);
    }
    
    

    @Override
    public List<Aula> listar() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Aula> listaAulas = em.createQuery("SELECT a FROM Aula a").getResultList();
        em.close();
        return (listaAulas);
    }
    
    
     @Override
    public List<Aula> listarAulasAluno(String nome) {
        EntityManager em = JpaUtil.getEntityManager();
        List<Aula> listaAulas = em.createQuery("SELECT a FROM Aula a WHERE a.nomeAluno LIKE :nomeAluno")
                .setParameter("nomeAluno", nome)
                .getResultList();
        em.close();
        return (listaAulas);
    }
    
       @Override
    public List<Aula> listarAulasProfessor(String nome) {
        EntityManager em = JpaUtil.getEntityManager();
        List<Aula> listaAulas = em.createQuery("SELECT a FROM Aula a WHERE a.nomeProfessor LIKE :nomeProfessor")
                .setParameter("nomeProfessor", nome)
                .getResultList();
        em.close();
        return (listaAulas);
    }
    
   
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import models.Usuario;
import util.JpaUtil;

/**
 *
 * @author Ricardo
 */
public class UsuarioDaoJpa implements UsuarioDao{
    
    @Override
    public void salvar(Usuario u) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        if (u.getId() == null) {
            em.persist(u);
        } else {
            em.merge(u);
        }
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void remover(Usuario u) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();        
        em.remove(em.merge(u));
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Usuario buscarPorId(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        Usuario usuario = em.find(Usuario.class, id);
        em.close();
        return (usuario);
    }
    
    

    @Override
    public List<Usuario> listar() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Usuario> listaUsuarios = em.createQuery("SELECT u FROM Usuario u").getResultList();
        em.close();
        return (listaUsuarios);
    }
    
    
     @Override
    public List<Usuario> listarAlunos() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Usuario> listaUsuarios = em.createQuery("SELECT u FROM Usuario u WHERE u.tipo = 2").getResultList();
        em.close();
        return (listaUsuarios);
    }
}

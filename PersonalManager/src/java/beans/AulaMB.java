/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.*;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import models.*;
import beans.*;

/**
 *
 * @author Ricardo
 */
@ManagedBean
@SessionScoped
public class AulaMB {

    /**
     * Creates a new instance of AulaMB
     */
    private Aula aula;
    private String nomeUsuarioLogado;

    public AulaMB() {
        aula = new Aula();
        FacesContext contexto = FacesContext.getCurrentInstance();
        
        
        LoginMB loginMB = (LoginMB) contexto.getExternalContext().getSessionMap().get("loginMB");
        
         nomeUsuarioLogado = loginMB.getUsuarioLogado().getNome();
    }

    /*public String addAluno(){
        
     }
    
     public String addProfessor(){
        
     }*/
    
    
    
    public String addAula(Usuario u) {
        

        AulaDao aulaBD = new AulaDaoJpa();

       
        String nomeProfessor = u.getNome();
        String modalidade = u.getModalidade();

        

        if(aula != null){
            
         this.aula.setNomeAluno(nomeUsuarioLogado);
         this.aula.setModalidade(modalidade);
         this.aula.setNomeProfessor(nomeProfessor);
            
         System.out.println(aula.getModalidade() + "\n" + aula.getNomeProfessor());
            
         aulaBD.salvar(aula);
         //usuarioAux = usuario;
            
       
         return (null);
         }
         else{
         return (null);
         }
       
        
    }
    
      public String delete(Aula a){
        AulaDao aulaBD = new AulaDaoJpa();
        aulaBD.remover(a);
       
        
        return null;
    }
    
    public List<Aula> getAulasAluno(){
        AulaDao aulaBD = new AulaDaoJpa();
        return aulaBD.listarAulasAluno(nomeUsuarioLogado);
    }
    
    public List<Aula> getAulasProfessor(){
        AulaDao aulaBD = new AulaDaoJpa();
        return aulaBD.listarAulasProfessor(nomeUsuarioLogado);
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    

}

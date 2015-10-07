/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;
import models.*;

/**
 *
 * @author Ricardo
 */
@ManagedBean
@ApplicationScoped
public class AulaMB {

    /**
     * Creates a new instance of AulaMB
     */
    private UsuarioMB usuarioMB;
    private Aula aula;
    private List<Aula> listaAulas;
    
    public AulaMB() {
        aula = new Aula();
        listaAulas = new ArrayList<Aula>();    
        FacesContext contexto = FacesContext.getCurrentInstance();
        usuarioMB = (UsuarioMB) contexto.getExternalContext().getSessionMap().get("usuarioMB");
    }
    
    /*public String addAluno(){
        
    }
    
    public String addProfessor(){
        
    }*/
    
    
    
    public String addAula() {
        if(aula != null){
            listaAulas.add(aula);
        //usuarioAux = usuario;
        this.aula = new Aula();
       
        return ("/professor/paginaDoProfessor?faces-redirect=true");
        }
        else{
            return ("/professor/paginaDoProfessor?faces-redirect=true");
        }
        /*if (usuarioAux.getTipo() == 1) {
         return ("/professor/paginaDoProfessor?faces-redirect=true"); //para Repeat, altere para usuariosRepeat
         } else {
         return ("/aluno/paginaDoAluno?faces-redirect=true"); //para Repeat, altere para usuariosRepeat
         }*/
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public UsuarioMB getUsuarioMB() {
        return usuarioMB;
    }

    public void setUsuarioMB(UsuarioMB usuarioMB) {
        this.usuarioMB = usuarioMB;
    }

    public List<Aula> getListaAulas() {
        return listaAulas;
    }

    public void setListaAulas(List<Aula> listaAulas) {
        this.listaAulas = listaAulas;
    }
    
    
    
    
    
}

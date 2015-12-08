/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import dao.*;
import java.util.ArrayList;
import java.util.List;
import models.Usuario;

/**
 *
 * @author Ricardo
 */
public class RepositorioProfessor {
    List<Usuario> professores;
    
    public RepositorioProfessor(){
        UsuarioDao usuarioBD = new UsuarioDaoJpa();
        professores = usuarioBD.listarProfessores();
    }

    public List<Usuario> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Usuario> professores) {
        this.professores = professores;
    }
    
    public void adicionar(Usuario u){
        professores.add(u);
    }
}

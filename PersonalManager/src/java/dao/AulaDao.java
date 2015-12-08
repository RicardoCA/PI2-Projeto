/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.*;
import models.Usuario;

/**
 *
 * @author Ricardo
 */
public interface AulaDao {
    public void remover(Aula a);
    public void salvar(Aula a);
    public Aula buscarPorId(Long id);
    public List<Aula> listar();   
    public List<Aula> listarAulasAluno(String nome);
    public List<Aula> listarAulasProfessor(String nome);

}

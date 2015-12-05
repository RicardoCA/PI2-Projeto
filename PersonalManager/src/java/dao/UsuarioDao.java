/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.Usuario;

/**
 *
 * @author Ricardo
 */
public interface UsuarioDao {
    public void remover(Usuario u);
    public void salvar(Usuario u);
    public Usuario buscarPorId(Long id);
    public List<Usuario> listar();   
    public List<Usuario> listarAlunos();
}

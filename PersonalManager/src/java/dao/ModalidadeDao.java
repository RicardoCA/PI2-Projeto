/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.Modalidade;
import models.Usuario;

/**
 *
 * @author Ricardo
 */
public interface ModalidadeDao {
    public void remover(Modalidade m);
    public void salvar(Modalidade m);
    public Modalidade buscarPorId(Long id);
    public List<Modalidade> listar();   

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Ricardo
 */
public class Aula implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String dia;
    private String hora;
    private String valor;

    private List<Integer> listaIdAlunos = new ArrayList();
    private int idProfessor;
    private int idModalidade;

    /*public Aula(String dia, String hora, Aluno aluno, Professor professor, String valor){
     this.dia = dia;
     this.hora = hora;
     this.aluno = aluno;
     this.professor = professor;
     this.valor = valor;
     }*/
    public Aula() {
        
    }

    public int getIdModalidade() {
        return idModalidade;
    }

    public void setIdModalidade(int idModalidade) {
        this.idModalidade = idModalidade;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public List<Integer> getListaIdAlunos() {
        return listaIdAlunos;
    }

    public void setListaIdAlunos(List<Integer> listaIdAlunos) {
        this.listaIdAlunos = listaIdAlunos;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    

}

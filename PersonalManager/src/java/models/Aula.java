/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Ricardo
 */
public class Aula {
    
    private String dia;
    private String hora;
    private Usuario usuario;
    private String valor;
    
    /*public Aula(String dia, String hora, Aluno aluno, Professor professor, String valor){
        this.dia = dia;
        this.hora = hora;
        this.aluno = aluno;
        this.professor = professor;
        this.valor = valor;
    }*/
    
    
    
    public Aula(){
        usuario = new Usuario();
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

   
    

   
    
    
    
}

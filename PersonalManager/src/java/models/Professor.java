package models;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Usuario{
    
    
    private double valorAula;
    private String disciplina;
    private String registroProfissional;

    public Professor() {
    }

   

    public double getValorAula() {
        return valorAula;
    }

    public void setValorAula(double valorAula) {
        this.valorAula = valorAula;
    }

    public String getRegistroProfissional() {
        return registroProfissional;
    }

    public void setRegistroProfissional(String registroProfissional) {
        this.registroProfissional = registroProfissional;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
    
    
    
    

    
}
    

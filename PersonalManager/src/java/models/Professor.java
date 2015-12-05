package models;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Usuario{
    
    
    private double valorAula;
    
    private String registroProfissional;
    
    Modalidade modalidade;

    public Professor() {
        this.modalidade = new Modalidade();
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

   
    
    
    

    
}
    

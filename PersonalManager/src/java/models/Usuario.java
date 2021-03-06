package models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Usuario implements Serializable{
    
    public static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    public final static int MASCULINO = 1;
    public final static int FEMININO = 2;
    
    public final static int PROFESSOR = 1;
    public final static int ALUNO = 2;
    public final static int ADMIN = 3;
    
    private String nome;
    private String telefone;
    private String email;
    private String login;
    private String senha;
    private int sexo;
    private String estado;
    private int tipo;
    
    
    private String modalidade;
    private String valor;
    
    
    
   
    
    public Usuario() {
        
    }
    
    public Usuario(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    
    
    
    
     public void limparCampos(){
        setNome("");
        setTelefone("");
        setEmail("");
        setLogin("");
        setSenha("");
    }
     
     public boolean retornaTipoBoolean(){
         if(this.tipo == 1){
             return true;
         }
         else{
             return false;
         }
     }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }
     
     

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getSexo() {
        return sexo;
    }
    
    public String getSexoString() {
        if(sexo==1) return "Masculino";
        else return "Feminino";
    }
    
    public String getTipoString() {
        if(tipo==1){
            return "Professor";
        }
        else if(tipo == 2){
            return "Aluno";
        }
        else if(tipo == 3){
            return "Admin";
        }
        else{
            return "";
        }
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    public boolean verificaLogin(String login, String senha){
        return(this.login.equals(login) && this.senha.equals(senha));
    }
}
    

package models;

public class Usuario {
    public final static int MASCULINO = 1;
    public final static int FEMININO = 2;
    
    public final static int PROFESSOR = 1;
    public final static int ALUNO = 2;
    
    
    private String nome;
    private String telefone;
    private String email;
    private String login;
    private String senha;
    private int sexo;
    private String estado;
    private int tipo;
    
   
    
    public Usuario() {
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
        if(tipo==1) return "Professor";
        else return "Aluno";
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
    

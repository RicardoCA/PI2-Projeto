package beans;

import dao.UsuarioDao;
import dao.UsuarioDaoJpa;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import models.*;

@ManagedBean
@SessionScoped
public class UsuarioMB {

    private Usuario usuario;
    private Usuario usuarioAux;
    private List<Usuario> listaUsuarios;
    private int indice;
    
    
    
    
    //
    private List<Usuario> listaProfessores = new ArrayList<Usuario>();
    private List<Usuario> listaAlunos = new ArrayList<Usuario>();
    //

    public UsuarioMB() {
        
        
        
        
        usuario = new Usuario();
        listaUsuarios = new ArrayList<Usuario>();
    }
    
    
    public void povoarListas(){
        for(int i = 0; i < listaUsuarios.size(); i++){
            if(listaUsuarios.get(i) != null){
                if(listaUsuarios.get(i).getTipo() == 1){
                    listaProfessores.add(listaUsuarios.get(i));
                }
                else{
                    listaAlunos.add(listaUsuarios.get(i));
                }
            }
        }
    }
    
   

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public String addUsuario() {
        UsuarioDao usuarioJPA = new UsuarioDaoJpa();
        usuarioJPA.salvar(usuario);
        
        listaUsuarios.add(usuario);
        usuarioAux = usuario;
        this.usuario = new Usuario();
        FacesContext contexto = FacesContext.getCurrentInstance();
        //LoginMB loginMB = (LoginMB) contexto.getExternalContext().getSessionMap().get("loginMB");
        //loginMB.setLogin(usuarioAux.getLogin());
        //loginMB.setSenha(usuarioAux.getSenha());
        return ("index?faces-redirect=true");/*loginMB.verificaLogin();*/
        /*if (usuarioAux.getTipo() == 1) {
         return ("/professor/paginaDoProfessor?faces-redirect=true"); //para Repeat, altere para usuariosRepeat
         } else {
         return ("/aluno/paginaDoAluno?faces-redirect=true"); //para Repeat, altere para usuariosRepeat
         }*/
    }

    public String editarUsuario() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        LoginMB loginMB = (LoginMB) contexto.getExternalContext().getSessionMap().get("loginMB");
        usuarioAux = loginMB.getUsuarioLogado();
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i) != null) {
                if (usuarioAux.getLogin().equals(listaUsuarios.get(i).getLogin())) {
                    indice = i;
                }
            }
        }
        if (usuarioAux.getTipo() == 1) {
            return ("/professor/formularioEdicaoProfessor?faces-redirect=true");
        } else {
            return ("/aluno/formularioEdicaoAluno?faces-redirect=true");
        }
    }

    public String atualizarUsuario() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        LoginMB loginMB = (LoginMB) contexto.getExternalContext().getSessionMap().get("loginMB");
        listaUsuarios.set(indice, loginMB.getUsuarioLogado());
        if (usuarioAux.getTipo() == 1) {
            return ("/professor/paginaDoProfessor?faces-redirect=true");
        } else {
            return ("/aluno/paginaDoAluno?faces-redirect=true");
        }
    }

    public String removerUsuario() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        LoginMB loginMB = (LoginMB) contexto.getExternalContext().getSessionMap().get("loginMB");
        if (listaUsuarios.contains(loginMB.getUsuarioLogado())) {
            listaUsuarios.remove(loginMB.getUsuarioLogado());
            loginMB.realizaLogout();
        }
        return ("/index?faces-redirect=true");
        
        
    }

    public String cadastrarUsuario() {

        if (!getUsuario().getEmail().equals("")) {
            return ("formulario_cadastro?faces-redirect=true");
        } else {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Digite um e-mail válido!", "Erro");

            contexto.addMessage(
                    "idEmailMensagem", mensagem);
            return ("index");
        }

    }

}

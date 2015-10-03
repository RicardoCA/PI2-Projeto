package beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;

import models.*;

@ManagedBean
@ApplicationScoped
public class UsuarioMB {

    private Usuario usuario;
    private Usuario usuarioAux;
    private List<Usuario> listaUsuarios;
    private int indice;

    public UsuarioMB() {
        usuario = new Usuario();
        listaUsuarios = new ArrayList<Usuario>();
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
        listaUsuarios.add(usuario);
        usuarioAux = usuario;
        this.usuario = new Usuario();
        FacesContext contexto = FacesContext.getCurrentInstance();
        LoginMB loginMB = (LoginMB) contexto.getExternalContext().getSessionMap().get("loginMB");
        //LoginMB loginMB = new LoginMB();
        loginMB.setLogin(usuarioAux.getLogin());
        loginMB.setSenha(usuarioAux.getSenha());
        return loginMB.verificaLogin();
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
        }
        return ("/index?faces-redirect=true");
    }
    
    
    public String cadastrar(){
        
        if(!getUsuario().getEmail().equals("")){
            return ("formulario_cadastro?faces-redirect=true");
        }
        else{
        
        FacesContext contexto = FacesContext.getCurrentInstance();
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Digite um email válido!", "Erro");
        
        contexto.addMessage(
                "idEmailMensagem", mensagem);
        return("index");
        }
        
    }
}

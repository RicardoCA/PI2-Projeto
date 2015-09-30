package beans;


import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import models.*;

@ManagedBean
@SessionScoped
public class UsuarioMB {
    private Usuario usuario;
    private List<Usuario> listaUsuarios;

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
    
    public String addUsuario(){
        listaUsuarios.add(usuario);
        this.usuario = new Usuario();
        return("aluno/index"); //para Repeat, altere para usuariosRepeat
    }
}

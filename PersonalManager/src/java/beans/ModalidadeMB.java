package beans;

import dao.ModalidadeDao;
import dao.ModalidadeDaoJpa;
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
public class ModalidadeMB {

    private Modalidade modalidade;
    private Modalidade modalidadeAux;
    private List<Modalidade> listaModalidades;
    private int indice;

    public ModalidadeMB() {

        listaModalidades = new ArrayList<Modalidade>();
        modalidade = new Modalidade();
        //iniciate();
    }

    public Modalidade getModalidade() {
        return modalidade;
    }

    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }

    public Modalidade getModalidadeAux() {
        return modalidadeAux;
    }

    public void setModalidadeAux(Modalidade modalidadeAux) {
        this.modalidadeAux = modalidadeAux;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
    
    public void iniciate() {
        ModalidadeDao modalidadeBD = new ModalidadeDaoJpa();
        
        Modalidade m1 = new Modalidade("Musculação");
        Modalidade m2 = new Modalidade("Natação");
        Modalidade m3 = new Modalidade("Pilates");
        Modalidade m4 = new Modalidade("Yoga");
        Modalidade m5 = new Modalidade("Alongamento");

        listaModalidades.add(m1);
        listaModalidades.add(m2);
        listaModalidades.add(m3);
        listaModalidades.add(m4);
        listaModalidades.add(m5);
        
        modalidadeBD.salvar(m1);
        modalidadeBD.salvar(m2);
        modalidadeBD.salvar(m3);
        modalidadeBD.salvar(m4);
        modalidadeBD.salvar(m5);
        
        
        
    }
    
    public List<Modalidade> getModalidades() {
        ModalidadeDao modalidadeBD = new ModalidadeDaoJpa();
        this.listaModalidades = modalidadeBD.listar();
        return this.listaModalidades;
    }

    public void povoarListas() {
        for (int i = 0; i < listaModalidades.size(); i++) {
            if (listaModalidades.get(i) != null) {

                listaModalidades.add(listaModalidades.get(i));

            }
        }
    }

    public void setListaModalidades(List<Modalidade> listaModalidades) {
        this.listaModalidades = listaModalidades;
    }

    public String addModalidade() {
        ModalidadeDao modalidadeJPA = new ModalidadeDaoJpa();
        modalidadeJPA.salvar(modalidade);

        listaModalidades.add(modalidade);
        modalidadeAux = modalidade;
        this.modalidade = new Modalidade();
        FacesContext contexto = FacesContext.getCurrentInstance();
        
        return  ("/admin/visualizarModalidades?faces-redirect=true");/*loginMB.verificaLogin();*/
       

    }
    
    
     public String delete(Modalidade m){
        ModalidadeDao modalidadeBD = new ModalidadeDaoJpa();
        modalidadeBD.remover(m);
       
        
        return null;
    }

}

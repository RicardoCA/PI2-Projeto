
import java.util.List;
import javax.ws.rs.core.GenericType;
import models.Usuario;
import ws.ClienteUsuario;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ricardo
 */
public class MainClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ClienteUsuario usuario = new ClienteUsuario();
        
        List<Usuario> usuarios = usuario.getUsuarios(new GenericType<List<Usuario>>(){});
        
        for (Usuario usuario1 : usuarios) {
            System.out.println(usuario1.getNome() + " - " + usuario1.getModalidade() + " - " + usuario1.getValor());
        }
    }
    
}

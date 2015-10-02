package filtro;


import beans.LoginMB;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter(filterName = "FiltroLogin", urlPatterns = {"/faces/index.xhtml"})
public class FiltroLogin implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        System.out.println("Verificando login!");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        LoginMB auth = (LoginMB) req.getSession().getAttribute("loginMB");
        if(auth!=null && auth.estaLogado()){
            if(auth.getUsuarioLogado().getTipo() == 1)
                resp.sendRedirect(req.getContextPath()+"/faces/professor/paginaDoProfessor.xhtml");
            else
                resp.sendRedirect(req.getContextPath()+"/faces/aluno/paginaDoAluno.xhtml");
        }            
        else
            chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

}

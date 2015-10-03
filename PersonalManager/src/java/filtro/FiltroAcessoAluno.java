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

/**
 *
 * @author lhries
 */
@WebFilter(filterName = "FiltroAcessoAluno", urlPatterns = {"/faces/aluno/*"})
public class FiltroAcessoAluno implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        System.out.println("Verificando acesso do usuario!");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        LoginMB auth = (LoginMB) req.getSession().getAttribute("loginMB");
        if(auth!=null && auth.estaLogado() && auth.getUsuarioLogado().getTipo() == 2)
            chain.doFilter(request, response);
        else
            resp.sendRedirect(req.getContextPath()+"/faces/index.xhtml");
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

}

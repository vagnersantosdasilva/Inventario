package Seguranca;

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
import javax.servlet.http.HttpSession;
import Entidades.Usuario;

/**
 * Servlet Filter implementation class FiltroDeSeguranca
 */

@WebFilter("/protegido/*")
public class FiltroDeSeguranca implements Filter 
{

	public void destroy() 
	{
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
		
		HttpServletResponse res = (HttpServletResponse)response;
		HttpServletRequest req =(HttpServletRequest) request;
		//Checar se objeto usuario está carregado na sessão 
		HttpSession session = req.getSession();
		//String endereco = requisicao.getRequestURI();
		Usuario usuario = (Usuario)session.getAttribute("usuario");
		if (usuario==null)
		{
			try {
				res.sendRedirect("/Inventario/login.jsp");
			} catch (IOException  e) {
				// TODO Auto-generated catch block
				System.out.println("Erro[FiltroSegurança]:"+e.getMessage());
			}
		}
		else
		{
			try	{
				chain.doFilter(request, response);
			} 
			catch (IOException | ServletException e)
			{
				System.out.println("Erro[FiltroSegurança]:"+e.getMessage());
			}
		
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException 
	{
		
	}

}

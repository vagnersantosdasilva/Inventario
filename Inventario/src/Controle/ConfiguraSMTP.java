package Controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.PropriedadesSMTPDAO;
import Util.Cripto;


/**
 * Servlet implementation class ConfiguraSMTP
 */
@WebServlet("/ConfiguraSMTP")
public class ConfiguraSMTP extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		
		String servidor = request.getParameter("servidorSMTP");
		String porta = request.getParameter("portaSMTP");
		String emailOrigem = request.getParameter("emailOrigem");
		String senha = request.getParameter("acesso");
		String ssl = request.getParameter("ssl");
		
		Cripto cripto = new Cripto(31,13,17,7,2,3,1);
		List<String> lista = new ArrayList<String>();
		lista.add("servidorSMTP="+servidor);
		lista.add("portaSMTP="+porta);
		lista.add("emailOrigem="+emailOrigem);
		lista.add("senha="+cripto.cifrar(senha));
		lista.add("ssl="+ssl);
		
		ServletContext context = request.getServletContext(); 
		String path = context.getRealPath("/");
		
		if (gravarPropriedadesSMTP(lista ,path)) 
		{
			System.out.println("Gravação de arquivo de smtp.cfg realizada com sucesso!");
			session.setAttribute("mensagem", "1");
			response.sendRedirect("/Inventario/config/config.jsp");
		}else 
		{
			session.setAttribute("mensagem", "2");
			response.sendRedirect("/Inventario/config/config.jsp");	
		}
		
	
	}
	
	private boolean gravarPropriedadesSMTP(List lista,String path) 
	{
		try 
		{
			String locais = path+"WEB-INF\\propriedades\\locais.cfg";
			String arquivoPropriedades = Util.Propriedades.lePropriedades("localAplicacao",locais )+"\\WebContent\\WEB-INF\\propriedades\\smtp.cfg"; 
			PropriedadesSMTPDAO dao = new PropriedadesSMTPDAO(arquivoPropriedades);
			dao.gravarPropriedades(lista);
			return true;
		}
		catch(IOException e) 
		{
			System.out.println("Erro[ConfiguraSMTP:gravarPropriedadesSMTP] : "+e.getMessage());
			e.printStackTrace();
			
		}
		return false;
		
	}

}

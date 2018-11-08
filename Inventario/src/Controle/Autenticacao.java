package Controle;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.PropriedadesJDBCDAO;
import DAO.PropriedadesSGBDDAO;
import DAO.ServicoDAO;
import DAO.Usuarios;
import Entidades.Propriedades;
import Entidades.PropriedadesJDBC;
import Entidades.PropriedadesSGBD;
import Entidades.Usuario;

@WebServlet("/autenticar")
public class Autenticacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  
	{
		try 
		{
			HttpSession session = request.getSession();
			ServletContext context = request.getServletContext(); 
			String path = context.getRealPath("/");
			Propriedades propriedades = obterPropriedades(path);
			String nomeUsuario= request.getParameter("nomeUsuario");
			String acesso = request.getParameter("acesso");
			
			if (propriedades!=null) 
			{
				if ((nomeUsuario=="") || (acesso==""))
				{
					response.sendRedirect("login.jsp");
				}
				ServicoDAO servico = ServicoDAO.getInstace(propriedades);
				Connection conn = (Connection) servico.obterConexao();
				Usuarios dao = new Usuarios();
				Usuario usuario=dao.getUsuario(conn,nomeUsuario,acesso);
				System.out.println("Usuario obtido :"+usuario.getNomeUsuario());
				if (usuario.getNomeUsuario()==null)
				{
					System.out.println("Teste de autenticacao falhou");
					session.setAttribute("mensagem", "1");
					response.sendRedirect("login.jsp");
				}
				else
				{
					System.out.println("Teste de autenticacao teve sucesso");
					session.setAttribute("usuario", usuario);
					session.setAttribute("mensagem", "0");
					response.sendRedirect("protegido/index.html");
				}
			}
			else 
			{
				System.out.println("[Escopo:Autenticacao] : Proriedades não retornaram valores. Ambiente não configurado!");
				session.setAttribute("mensagem", "2");
				response.sendRedirect("login.jsp");
			}
		}
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("[Autenticar]:ClassNotFoundException:"+e.getMessage());
			response.sendRedirect("login.jsp");
		}
		catch(SQLException e)
		{
			System.out.println("[Autenticar]:SQLException:"+e.getMessage());
		}
	}
	
	private Propriedades obterPropriedades(String path) 
	{
		try {
			String propriedades_banco =path+"WEB-INF\\propriedades\\bd.cfg";
			String jdbc = path+"WEB-INF\\propriedades\\jdbc.cfg";
			PropriedadesJDBCDAO jdbcdao = new PropriedadesJDBCDAO(jdbc);
			PropriedadesSGBDDAO sgbddao = new PropriedadesSGBDDAO(propriedades_banco);
			PropriedadesSGBD propsgbd = sgbddao.obterPropriedades();
			PropriedadesJDBC propjdbc = jdbcdao.obterPropriedades(propsgbd.getSGBD());
			Propriedades propriedades = new Propriedades(propsgbd,propjdbc);
			return propriedades;
		}	
		catch(NullPointerException e) 
		{
			System.out.println("Erro[Autenticacao:obterPropriedades]"+e.getMessage());	
		}
		return null;
	}
}

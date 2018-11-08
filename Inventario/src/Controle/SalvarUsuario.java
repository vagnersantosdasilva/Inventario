package Controle;

import java.io.IOException;
import java.sql.Connection;
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

/**
 * Servlet implementation class SalvarUsuario
 */
@WebServlet(name = "salvarusuario", urlPatterns = { "/salvarusuario" })
public class SalvarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		HttpSession session = request.getSession();
		Usuario root = (Usuario) session.getAttribute("usuario");
		if (root==null)
		{
			try 
			{
				request.getRequestDispatcher("/login.jsp").forward(request,response);
			} 
			catch (Exception  e) 
			{
				System.out.println("Erro[Servlet - SalvarLicenca]:"+e.getMessage());
				response.sendRedirect("/retornoErro.jsp");
			}
		}
		ServletContext context = request.getServletContext(); 
		String path = context.getRealPath("/");
		Propriedades propriedades = obterPropriedades(path);
		Usuario novoUsuario =new Usuario();
		String contexto=request.getParameter("contexto");
		novoUsuario.setNomeUsuario(request.getParameter("nome"));
   		novoUsuario.setChaveAcesso(request.getParameter("chave"));
   		novoUsuario.setGrupoAcesso(request.getParameter("grupo"));
   		novoUsuario.setEmail(request.getParameter("email"));
   		novoUsuario.setTelefone(request.getParameter("telefone"));
   		if (novoUsuario.equals(null) ||novoUsuario.getNomeUsuario()=="")
   		{
   			request.setAttribute("erro", "Usuário definido incorretamente");
			request.getRequestDispatcher("/retornoErro.jsp").forward(request, response);
		}
		else
		{
			try
			{
				ServicoDAO servico = ServicoDAO.getInstace(propriedades);
				Connection conn= servico.obterConexao(); 
				Usuarios dao = new Usuarios();
				if (contexto.equals("editar"))
				{
					if (dao.atualizarRegistro(conn, novoUsuario))
					{
						conn.commit();
						conn.close();
					}
					else
					{
						System.out.println("Não foi possível atualizar o registro. ");
						conn.rollback();
						conn.close();
					}
				}
				if(contexto.equals("incluir"))
				{
					if(dao.incluir(conn, novoUsuario))
					{
						conn.commit();
						conn.close();
					}
					else
					{
						System.out.println("Não foi possível incluir o registro de usuario. ");
						conn.rollback();
						conn.close();
					}
				}
				if (contexto.equals(null))
				{
					System.out.println("Erro SalvarUsuario[Funçao não definida]");
				}
			}catch(Exception e)
			{
				System.out.println("Erro[SalvarUsuario["+e.getMessage()+"]");
				e.printStackTrace();
			}
				response.sendRedirect("/Inventario/listar");
		}

	}
	private Propriedades obterPropriedades(String path) 
	{
		String bd =path+"WEB-INF\\propriedades\\bd.cfg";
		String jdbc = path+"WEB-INF\\propriedades\\jdbc.cfg";
		PropriedadesJDBCDAO jdbcdao = new PropriedadesJDBCDAO(jdbc);
		PropriedadesSGBDDAO sgbddao = new PropriedadesSGBDDAO(bd);
		PropriedadesSGBD propsgbd = sgbddao.obterPropriedades();
		PropriedadesJDBC propjdbc = jdbcdao.obterPropriedades(propsgbd.getSGBD());
		Propriedades propriedades = new Propriedades(propsgbd,propjdbc);
		
		return propriedades;
	}
   	
}

package Controle;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

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
import Entidades.Maquina;
import Entidades.Propriedades;
import Entidades.PropriedadesJDBC;
import Entidades.PropriedadesSGBD;
import Entidades.Usuario;
import Testes.MockPersistencia;

/**
 * Servlet implementation class Listar
 */
@WebServlet("/listar")
public class Listar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			ServletContext context = request.getServletContext(); 
			String path = context.getRealPath("/");
			
			Propriedades propriedades = obterPropriedades(path);
			
			HttpSession session = request.getSession();
			Usuario root = (Usuario) session.getAttribute("usuario");
			if (root==null)
			{
				try {
					request.getRequestDispatcher("/login.jsp").forward(request,response);
				} catch (Exception  e) {
					// TODO Auto-generated catch block
					System.out.println("Erro[Servlet - Listar]:"+e.getMessage());
					response.sendRedirect("/retornoErro.jsp");
				}
			}
			else
			{
				ServicoDAO servico = ServicoDAO.getInstace(propriedades);
				Connection conn= servico.obterConexao();
				Usuarios usuarios = new Usuarios();
				usuarios.setListaDeUsuarios(conn);
				//List<Usuario> lista = usuarios.getListaDeUsuarios();
				request.setAttribute("usuarios",usuarios);
				request.getRequestDispatcher("/protegido/gerenciarUsuarios.jsp").forward(request,response);
			}
		}
		catch(Exception e)
		{
			System.out.println("[Servlet:Listar]");
			
			request.setAttribute("erro", "Um erro ocorreu em Controle[Listar]]");
			request.getRequestDispatcher("/retornoErro.jsp").forward(request, response);
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

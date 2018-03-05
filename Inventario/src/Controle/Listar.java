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

import DAO.ServicoDAO;
import DAO.Usuarios;
import Entidades.Maquina;
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
			String arquivoPropriedades=path+"propriedades.txt";
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
				ServicoDAO servico = ServicoDAO.getInstace(arquivoPropriedades);
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

}

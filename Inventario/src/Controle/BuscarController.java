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

import DAO.Maquinas;
import DAO.ServicoDAO;
import Entidades.Maquina;
import Entidades.Usuario;
import Testes.MockPersistencia;


@WebServlet(name = "Buscar", urlPatterns = { "/buscar" })
public class BuscarController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
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
					System.out.println("Erro[BuscarController:doGet:autenticacao]:"+e.getMessage());
					response.sendRedirect("/retornoErro.jsp");
				}
			}
			
			ServletContext context = request.getServletContext(); 
			String path = context.getRealPath("/");
			String arquivoPropriedades=path+"propriedades.txt";
			ServicoDAO servico = ServicoDAO.getInstace(arquivoPropriedades);
			Connection conn= servico.obterConexao();  

			
			String item = request.getParameter("procurar");
			//MockPersistencia DAO = new MockPersistencia();
			//DAO.popularRepositorio();
			Maquinas maquinas= Maquinas.getInstance();
			Maquina host =new Maquina();
			host = maquinas.buscarMaquinaPorHostName(conn, item);
			
			//host=DAO.buscarMaquina(item);
			
			if (host.getHostname()==null)
			{
				String mensagem = "Máquina não encontrada";
				request.setAttribute("erro", mensagem);
				request.getRequestDispatcher("/retornoErro.jsp").forward(request, response);
			}	
			
			request.setAttribute("maquina",host);
			request.getRequestDispatcher("/protegido/inventario.jsp").forward(request,response);
					
		}
		catch(Exception e)
		{
			System.out.println("Erro-Servlet[BuscarControler:doGet]"+e.getMessage() );
			e.printStackTrace();
		}
	}		
}

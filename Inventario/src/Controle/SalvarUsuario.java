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

import DAO.ServicoDAO;
import DAO.Usuarios;
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
		String arquivoPropriedades=path+"propriedades.txt";
		System.out.println(arquivoPropriedades);
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
				ServicoDAO servico = ServicoDAO.getInstace(arquivoPropriedades);
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
   	
}

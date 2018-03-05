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
import DAO.ServicoDAO;
import DAO.Usuarios;
import Entidades.Usuario;

@WebServlet("/autenticar")
public class Autenticacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  
	{
		ServletContext context = request.getServletContext(); 
		String path = context.getRealPath("/");
		String arquivoPropriedades=path+"propriedades.txt";
		String nomeUsuario= request.getParameter("nomeUsuario");
		String acesso = request.getParameter("acesso");
		
		
		if ((nomeUsuario=="") || (acesso==""))
		{
			response.sendRedirect("login.jsp");
		}
		try 
		{
			HttpSession session = request.getSession();
			ServicoDAO servico = ServicoDAO.getInstace(arquivoPropriedades);
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
				response.sendRedirect("/Inventario/protegido/index.html");
				
				//response.sendRedirect("/Inventario/protegido/index.html");
				//request.getRequestDispatcher("protegido/dash/index.html").forward(request,response);
			}
		}
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("[Autenticar]:ClassNotFoundException:"+e.getMessage());
		}
		catch(SQLException e)
		{
			System.out.println("[Autenticar]:SQLException:"+e.getMessage());
		}	
	}
}

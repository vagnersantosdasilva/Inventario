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

/**
 * Servlet implementation class AlterarPerfil
 */
@WebServlet(description = "Alterações do login feitas pelo próprio usuario", urlPatterns = { "/alterarPerfil" })
public class AlterarPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		System.out.println("Nome 	:"+request.getParameter("nome"));
   		System.out.println("Grupo	:"+request.getParameter("grupo"));
   		System.out.println("Email	:"+request.getParameter("email"));
   		System.out.println("Telefone:"+request.getParameter("telefone"));
   		System.out.println("Acesso	:"+request.getParameter("acesso"));
   		//String novaSenha = request.getParameter("acesso");
   			
   		//if (request.getParameter("renovarSenha")!=null) System.out.println(request.getParameter("renovaSenha"));
   		
   		Usuario root = (Usuario) session.getAttribute("usuario");
		if (root==null)
		{
			try 
			{
				System.out.println("[Nenhum usuário encontrado em Sessão]");
				request.getRequestDispatcher("/login.jsp").forward(request,response);
			} 
			catch (Exception  e) 
			{
				System.out.println("[Nenhum usuário encontrado em Sessão]");
				System.out.println("Erro[SalvarLicenca:doPost]:"+e.getMessage());
				response.sendRedirect("/retornoErro.jsp");
			}
		}
		ServletContext context = request.getServletContext(); 
		String path = context.getRealPath("/");
		Propriedades propriedades = obterPropriedades(path);
		Usuario usuario =new Usuario();
		usuario.setNomeUsuario(request.getParameter("nome"));
   		usuario.setGrupoAcesso(request.getParameter("grupo"));
   		usuario.setEmail(request.getParameter("email"));
   		usuario.setTelefone(request.getParameter("telefone"));
   		String novaSenha = request.getParameter("acesso");
   		boolean renovarSenha=false;
   		if (request.getParameter("renovarSenha")!=null) { renovarSenha = request.getParameter("renovarSenha").equals("sim")?true:false;}
   		if (usuario.equals(null) || usuario.getNomeUsuario()=="")
   		{
   			System.out.println("[SalvarUsuario:doPost] :Usuario não autenticado");
   			request.setAttribute("erro", "Usuário definido incorretamente!");
			request.getRequestDispatcher("/retornoErro.jsp").forward(request, response);
		}
		else
		{
			try {
				ServicoDAO servico = ServicoDAO.getInstace(propriedades);
				Connection conn= servico.obterConexao();
				Usuarios dao = new Usuarios();
				if (dao.atualizarRegistro(conn, usuario)) {
					conn.commit();
					session.setAttribute("usuario", usuario);
					System.out.println("ESCOPO:[AlterarPerfil:doPost]: Usuario atualizado");
				}
				if (renovarSenha) {
					if (dao.atualizarChaveAcesso(conn, usuario, novaSenha)) {
						System.out.println("ESCOPO:[AlterarPerfil:doPost]: Usuario teve senha alterada");
						conn.commit();
					}
				}
				conn.close();
				session.setAttribute("resposta", "SUCESSO");
				response.sendRedirect("/Inventario/listarPerfil");
				
			} catch (ClassNotFoundException e) {
				System.out.println("Erro[AlterarPerfil:doPost]:ServicoDAO :"+e.getMessage());
				e.printStackTrace();
				session.setAttribute("classe", "ERRO");
				response.sendRedirect("/Inventario/listarPerfil");
			} catch (SQLException e) {
				System.out.println("Erro[AlterarPerfil:doPost] :"+e.getMessage());
				e.printStackTrace();
				session.setAttribute("sql", "ERRO");
				response.sendRedirect("/Inventario/listarPerfil");
			} 
			
			
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



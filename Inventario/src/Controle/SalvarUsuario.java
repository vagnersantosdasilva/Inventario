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

import org.apache.commons.mail.EmailException;

import DAO.PropriedadesJDBCDAO;
import DAO.PropriedadesSGBDDAO;
import DAO.PropriedadesSMTPDAO;
import DAO.ServicoDAO;
import DAO.Usuarios;
import Entidades.ParametrosEmail;
import Entidades.Propriedades;
import Entidades.PropriedadesJDBC;
import Entidades.PropriedadesSGBD;
import Entidades.Usuario;
import Util.Email;

/**
 * Servlet implementation class SalvarUsuario
 */
@WebServlet(name = "salvarusuario", urlPatterns = { "/salvarusuario" })
public class SalvarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 try 
		 {
			Thread.sleep(1500);
		 } catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		 }
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
				System.out.println("Erro[SalvarLicenca:doPost]:"+e.getMessage());
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
   		boolean reset = request.getParameter("reset").equals("sim")?true:false;
   		
   		if (novoUsuario.equals(null) ||novoUsuario.getNomeUsuario()=="")
   		{
   			request.setAttribute("erro", "Usu�rio definido incorretamente!");
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
					if(reset){ 
						if (reset(dao,conn,novoUsuario,path)) {
							response.setContentType("text/plain");
							response.setCharacterEncoding("UTF-8");
							response.getWriter().write("SUCESSO");
						}
						else {
							response.setContentType("text/plain");
							response.setCharacterEncoding("UTF-8");
							response.getWriter().write("FALHA");
						}
					}
					
					else {
						if (atualizar(dao,conn,novoUsuario)) {
							response.setContentType("text/plain");
							response.setCharacterEncoding("UTF-8");
							response.getWriter().write("SUCESSO");
						}else {
							response.setContentType("text/plain");
							response.setCharacterEncoding("UTF-8");
							response.getWriter().write("FALHA");
						}
					}
				}
				if(contexto.equals("incluir"))
				{
					if (incluir(dao,conn,novoUsuario)) {
						response.setContentType("text/plain");
						response.setCharacterEncoding("UTF-8");
						response.getWriter().write("SUCESSO");
					}else {
						response.setContentType("text/plain");
						response.setCharacterEncoding("UTF-8");
						response.getWriter().write("FALHA");
					}
					
				}
				if (contexto==null)
				{
					System.out.println("Erro SalvarUsuario[Fun��o n�o definida]");
					response.setContentType("text/plain");
					response.setCharacterEncoding("UTF-8");
					response.getWriter().write("FALHA");
				}
			}catch(EmailException e)
			{
				System.out.println("Erro[SalvarUsuario["+e.getMessage()+"]");
				e.printStackTrace();
			}catch(SQLException e) 
			{
				System.out.println("Erro[SalvarUsuario:doPost]"+e.getMessage());
			}
			catch(ClassNotFoundException e) 
			{
				
			}
				response.sendRedirect("/Inventario/listar");
		}
   		
   		
		
		 /*
   		 HttpSession session = request.getSession();
		System.out.println(request.getParameter("nome"));
		//System.out.println(request.getParameter("chave"));
		System.out.println(request.getParameter("email"));
		System.out.println(request.getParameter("telefone"));
		System.out.println(request.getParameter("reset"));
		System.out.println(request.getParameter("contexto"));
		System.out.println(request.getParameter("grupo"));
		
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
		
			response.getWriter().write("FALHA");
			//response.sendRedirect("/Inventario/listar");
   		*/ 

	}
	private void enviarEmail(Usuario usuario, String path) throws EmailException {
		String smtp =path+"WEB-INF\\propriedades\\smtp.cfg";
   		PropriedadesSMTPDAO dao = new PropriedadesSMTPDAO(smtp);
   		ParametrosEmail parametros = dao.obterPropriedades();
   		Email email = new Email(parametros,usuario.getEmail(),"Recupera��o de Senha","Uma nova senha foi gerada para sua conta:\nLogin :"+usuario.getNomeUsuario()+"\nNova Senha : "+usuario.getChaveAcesso());
		email.enviarEmail();
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
	private boolean incluir(Usuarios dao,Connection conn,Usuario usuario) throws SQLException 
	{
		System.out.println("Incluir usuario");
		if(dao.incluir(conn, usuario))
		{
			conn.commit();
			conn.close();
			return true;
		}
		System.out.println("N�o foi poss�vel incluir o registro de usuario. ");
		conn.rollback();
		conn.close();
		return false;
	}
	
	private boolean atualizar(Usuarios dao,Connection conn,Usuario usuario) throws SQLException
	{
		if (dao.atualizarRegistro(conn, usuario))
		{
			conn.commit();
			conn.close();
			return true;
		}
		
		System.out.println("N�o foi poss�vel atualizar o registro. ");
		conn.rollback();
		conn.close();
		return  false;
	}
	private boolean reset(Usuarios dao,Connection conn,Usuario usuario,String path) throws EmailException, SQLException 
	{
		String novaSenha = Util.GeradorDeSenhas.gerarSenha(6);
		usuario.setChaveAcesso(novaSenha);
		if (atualizar(dao,conn,usuario)) {
			System.out.println("Atualizar com reset de senha");
			enviarEmail(usuario,path);
			return true;
		}
		return false;
	}
	
}

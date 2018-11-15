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
   		novoUsuario.setGrupoAcesso(request.getParameter("grupo"));
   		novoUsuario.setEmail(request.getParameter("email"));
   		novoUsuario.setTelefone(request.getParameter("telefone"));
   		boolean reset=false;
   		boolean renovarSenha=false;
   		if (request.getParameter("reset")!=null) { reset = request.getParameter("reset").equals("sim")?true:false;}
   		if (novoUsuario.equals(null) ||novoUsuario.getNomeUsuario()=="")
   		{
   			System.out.println("[SalvarUsuario:doPost] :Usuario não autenticado");
   			request.setAttribute("erro", "Usuário definido incorretamente!");
			request.getRequestDispatcher("/retornoErro.jsp").forward(request, response);
		}
		else
		{
			try
			{
				ServicoDAO servico = ServicoDAO.getInstace(propriedades);
				Connection conn= servico.obterConexao(); 
				Usuarios dao = new Usuarios();
				session.removeAttribute("resposta");
				
				if (contexto.equals("editar"))
				{
					if(reset){ 
						if (reset(dao,conn,novoUsuario,path)) {
							System.out.println("Reset teve êxito!");
							session.setAttribute("resposta", "SUCESSO");
							response.sendRedirect("/Inventario/listar");
							
						}
						else {
							System.out.println("[SalvarUsuario:doPost:reset()] :Não foi possível mudar senha");
							System.out.println("Reset - Falha");
							session.setAttribute("resposta", "FALHA");
							response.sendRedirect("/Inventario/listar");
							
						}
					}
					else {
						if (atualizar(dao,conn,novoUsuario)) {
							System.out.println("Atualizar teve êxito!");
							session.setAttribute("resposta", "SUCESSO");
							response.sendRedirect("/Inventario/listar");
						}
						else {
							System.out.println("[SalvarUsuario:doPost:atualizar()] :Não foi possível atualizar usuario");
							System.out.println("Atualizar - Falha");
							session.setAttribute("resposta", "FALHA");
							response.sendRedirect("/Inventario/listar");
						}
					}
				}
				if(contexto.equals("incluir"))
				{
					if (incluir(dao,conn,novoUsuario)) {
						System.out.println("Incluir teve êxito!");
						session.setAttribute("resposta", "SUCESSO");
						response.sendRedirect("/Inventario/listar");
						
						
					}else {
						System.out.println("[SalvarUsuario:doPost:incluir()] :Não foi possível incluir usuário");
						session.setAttribute("resposta", "FALHA");
						response.sendRedirect("/Inventario/listar");
						
					}
				}
				if (contexto==null)
				{
					System.out.println("Erro SalvarUsuario[Função não definida]");
					session.setAttribute("resposta", "FALHA");
					response.sendRedirect("/Inventario/listar");
				}
			}catch(EmailException e)
			{
				session.setAttribute("smtp", "ERRO");
				System.out.println("Erro[SalvarUsuario["+e.getMessage()+"]");
				e.printStackTrace();
				response.sendRedirect("/Inventario/listar");
			}catch(SQLException e) 
			{
				session.setAttribute("sql", "ERRO");
				System.out.println("Erro[SalvarUsuario:doPost]"+e.getMessage());
				e.printStackTrace();
				response.sendRedirect("/Inventario/listar");
			}
			catch(ClassNotFoundException e) 
			{
				System.out.println("Erro[SalvarUsuario:doPost]"+e.getMessage());
				e.printStackTrace();
				response.sendRedirect("/Inventario/listar");
			}
				
		}
   		
	}
	private void enviarEmail(Usuario usuario, String path) throws EmailException {
		String smtp =path+"WEB-INF\\propriedades\\smtp.cfg";
   		PropriedadesSMTPDAO dao = new PropriedadesSMTPDAO(smtp);
   		ParametrosEmail parametros = dao.obterPropriedades();
   		Email email = new Email(parametros,usuario.getEmail(),"Recuperação de Senha","Uma nova senha foi gerada para sua conta:\nLogin :"+usuario.getNomeUsuario()+"\nNova Senha : "+usuario.getChaveAcesso());
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
			System.out.println("Incluir ["+usuario.getNomeUsuario()+"] teve êxito!");
			return true;
		}
		System.out.println("Incluir ["+usuario.getNomeUsuario()+"] NÃO teve êxito!");
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
			System.out.println("Atualizar ["+usuario.getNomeUsuario()+"] teve êxito!");
			return true;
		}
		
		System.out.println("Atualizar ["+usuario.getNomeUsuario()+"] NÂO teve êxito!");
		conn.rollback();
		conn.close();
		return  false;
	}
	private boolean reset(Usuarios dao,Connection conn,Usuario usuario,String path) throws EmailException, SQLException 
	{
		String novaSenha = Util.GeradorDeSenhas.gerarSenha(6);
		usuario.setChaveAcesso(novaSenha);
		if (dao.atualizarChaveAcesso(conn, usuario, novaSenha)) {
			System.out.println("Reset ["+usuario.getNomeUsuario()+"] teve êxito!");
			atualizar(dao,conn,usuario);
			enviarEmail(usuario,path);
			System.out.println("Envio de Email para ["+usuario.getEmail()+"] teve êxito!");
			return true;
		}
		System.out.println("Reset ["+usuario.getNomeUsuario()+"] NÂO teve êxito!");
		return false;
	}
	
}

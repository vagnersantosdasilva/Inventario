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
import Entidades.PropriedadesSMTP;
import Entidades.Usuario;
import Util.Email;


@WebServlet("/ResetDeSenha")
public class ResetDeSenha extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
   	{
   		try 
   		{
   			HttpSession session = request.getSession();
	   		String login = request.getParameter("nomeUsuario");
	   		String email = request.getParameter("email");
	   		String contexto = request.getParameter("contexto");
	   		
	   		System.out.println("Parametros recebidos"+login+" - "+email);
	   		
	   		ServletContext context = request.getServletContext(); 
			String path = context.getRealPath("/");
			Propriedades propriedades=obterPropriedades(path);
			ParametrosEmail parametros = obterPropriedadesSMTP(path);
		
			ServicoDAO servico = ServicoDAO.getInstace(propriedades);
			Connection conn= servico.obterConexao();
			
			
			Usuarios dao = new Usuarios();
	   		if (dao.existeUsuario(conn, login))
	   		{
	   			System.out.println ("Usuario existe");
	   			String novaChave=Util.GeradorDeSenhas.gerarSenha(6);
	   			Usuario user = dao.getUsuario(conn, login);
	   			if (user.getEmail().equals(email))
	   			{
		   			if (dao.atualizarChaveAcesso(conn, user, novaChave)) 
		   			{
		   				conn.commit();
		   				conn.close();
		   				System.out.println ("Login " +login+" teve senha alterada. ");
		   				try 
		   				{
			   				Email mensagem = new Email(parametros,user.getEmail(),"Recuperação de Senha S.A.I",
			   						"Uma nova senha foi gerada para sua conta:\n"+"Login :"+user.getNomeUsuario()+"\nNova Senha : "+novaChave);
			   				System.out.println("Uma mensagem sera enviada para o email "+user.getEmail());
							mensagem.enviarEmail();
							session.setAttribute("mensagem", "5");
							response.sendRedirect("/Inventario/recupera/recuperarSenha.jsp");
						} 
		   				catch (EmailException e) 
		   				{
							System.out.println("ResetDeSenha[doPost]"+e.getMessage());
							e.printStackTrace();
							session.setAttribute("mensagem", "1");
							response.sendRedirect("/Inventario/recupera/recuperarSenha.jsp");
						} 
			
		   			}
		   			else 
			   		{
		   				System.out.println("[ESCOLO:RESETDESENHA]:Não foi possível atualizar senha no banco");
			   			session.setAttribute("mensagem", "4");
						response.sendRedirect("/Inventario/recupera/recuperarSenha.jsp");
			   		}
		   		}
	   			else
	   			{
	   				//Email incorreto
	   				System.out.println("[ESCOPO:RESETDESENHA]: Email informado não cadastrado.");
	   				session.setAttribute("mensagem","2");
	   				response.sendRedirect("/Inventario/recupera/recuperarSenha.jsp");
	   			}
	   		}
	   		else
	   		{	
	   			//CondiÃ§Ã£o usuario inexistente
	   			session.setAttribute("mensagem", "3");
	   			response.sendRedirect("/Inventario/recupera/recuperarSenha.jsp");
	   		}
	   	} 
   		catch (SQLException e1) 
   		{
   			System.out.println("ResetDeSenha[doPost]"+e1.getMessage());
			e1.printStackTrace();
			
		}
   		catch(ClassNotFoundException  e1) 
		{
   			System.out.println("ResetDeSenha[doPost]"+e1.getMessage());
			e1.printStackTrace();
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
   	private ParametrosEmail obterPropriedadesSMTP(String path) 
   	{
   		String smtp =path+"WEB-INF\\propriedades\\smtp.cfg";
   		PropriedadesSMTPDAO dao = new PropriedadesSMTPDAO(smtp);
   		ParametrosEmail propriedades = dao.obterPropriedades();
   		return propriedades;
   	}

}

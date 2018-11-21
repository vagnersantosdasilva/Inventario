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

import com.google.gson.Gson;

import DAO.PropriedadesJDBCDAO;
import DAO.PropriedadesSGBDDAO;
import DAO.ServicoDAO;
import DAO.Usuarios;
import Entidades.PropriedadesJDBC;
import Entidades.PropriedadesSGBD;
import Entidades.Usuario;
import Util.Propriedades;


@WebServlet("/removerUsuario")
public class RemoverUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String codigo_usuario=request.getParameter("codigo_usuario");
		 try 
		 {
			Thread.sleep(1500);
		 } catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		 }
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
						System.out.println("Erro[Servlet - Remover]:"+e.getMessage());
						response.sendRedirect("/retornoErro.jsp");
					}
				}
				else
				{
					System.out.println("Recebido parametro :"+codigo_usuario);
					ServicoDAO servico = ServicoDAO.getInstace(propriedades);
					Connection conn= servico.obterConexao();
					Usuarios usuarios = new Usuarios();
					
					
					if (usuarios.existeUsuario(conn, codigo_usuario))
					{
						if(usuarios.excluir(conn, codigo_usuario))
						{
							usuarios.setListaDeUsuarios(conn);
							conn.commit();
							conn.close();
							request.setAttribute("usuarios",usuarios);
							response.setContentType("text/plain");
							response.setCharacterEncoding("UTF-8");
							response.getWriter().write("SUCESSO");
						}else
						{
							usuarios.setListaDeUsuarios(conn);
							conn.close();
							request.setAttribute("usuarios",usuarios);
							response.setContentType("text/plain");
							response.setCharacterEncoding("UTF-8");
							response.getWriter().write("NÃƒO FOI POSSÃ�VEL CONFIRMAR A OPERAÃ‡ÃƒO DE EXCLUSÃƒO");
							
						}
						
					}else
					{
						usuarios.setListaDeUsuarios(conn);
						conn.close();
						
						request.setAttribute("usuarios",usuarios);
						response.setContentType("text/plain");
						response.setCharacterEncoding("UTF-8");
						response.getWriter().write("USUÃ�RIO INIXISTENTE");
					}
				}
			}
			catch(Exception e)
			{
				System.out.println("[Servlet:Remover]");
				
				request.setAttribute("erro", "Um erro ocorreu em Controle[Remover]]");
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

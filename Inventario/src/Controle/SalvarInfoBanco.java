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

import DAO.BDDAO;
import DAO.PropriedadesJDBCDAO;
import DAO.PropriedadesSGBDDAO;
import DAO.ServicoDAO;
import Entidades.BD;
import Entidades.Propriedades;
import Entidades.PropriedadesJDBC;
import Entidades.PropriedadesSGBD;
import Entidades.Usuario;


@WebServlet(description = "Salvar InformaÃ§Ãµes sobre o banco de dados e rotinas de backup", urlPatterns = { "/salvarInfoBanco" })
public class SalvarInfoBanco extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
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
					System.out.println("Erro[Servlet - SalvarInforBanco]:"+e.getMessage());
					response.sendRedirect("/retornoErro.jsp");
				}
			}
			
			BDDAO dao = new BDDAO();
			BD banco  =new BD();
			banco.setNomeBanco(request.getParameter("nomeBanco"));
			banco.setNomeSGBD(request.getParameter("nomeSGBD"));
			banco.setPortaBanco(request.getParameter("porta"));
			banco.setIpBanco(request.getParameter("ip"));
			banco.setModoBackup(request.getParameter("modo"));
			banco.setFrequenciaBackup(request.getParameter("frequencia"));
			banco.setDataBackup(request.getParameter("dataBackup"));
			banco.setFormatoBackup(request.getParameter("formato"));
			
			ServletContext context = request.getServletContext(); 
			String path = context.getRealPath("/");
			Propriedades propriedades = obterPropriedades(path);
			ServicoDAO servico = ServicoDAO.getInstace(propriedades);
			Connection conn= servico.obterConexao();
			if (dao.atualizar(conn, banco)) 
			{
				System.out.println("Ocorreu atualização em Tabela infobanco");
				conn.commit();
				BD bd = dao.buscar(conn);
				conn.close();
				request.setAttribute("bd",bd);
				request.getRequestDispatcher("/protegido/baseDeDados.jsp").forward(request,response);
			}
		}catch(SQLException e) 
		{
			System.out.println("Erro[SalvarInfoBanco]:"+e.getMessage());
		}catch(ClassNotFoundException e) 
		{
			System.out.println("Erro[SalvarInfoBanco]:"+e.getMessage());
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

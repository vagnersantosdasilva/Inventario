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
import DAO.InventarioDAO;
import DAO.PropriedadesJDBCDAO;
import DAO.PropriedadesSGBDDAO;
import DAO.ServicoDAO;
import Entidades.InventarioCorporativo;
import Entidades.Propriedades;
import Entidades.PropriedadesJDBC;
import Entidades.PropriedadesSGBD;

/**
 * Servlet implementation class EditarInventario
 */
@WebServlet("/EditarInventario")
public class EditarInventario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try 
		{
			//User usuario = new User("root","abc123"); 
			
			/********** deverá ser movido para listener  ********/
			
			ServletContext context = request.getServletContext(); 
			String path = context.getRealPath("/");
			Propriedades propriedades = obterPropriedades(path);
			ServicoDAO servico = ServicoDAO.getInstace(propriedades);
			
			//ObterConexao tem que ser fornecido por um controle de acesso.
			Connection conn=servico.obterConexao();
			InventarioDAO inventarioDAO=new InventarioDAO();
			/**************************************************/
			String key=request.getParameter("maquina");
			//String detalhes=request.getParameter("detalhes");
			
			if (key!=null)
			{
					InventarioCorporativo inventario = inventarioDAO.obterInventario(conn, key);
					request.setAttribute("inventario",inventario);
			}
			else
			{
					InventarioCorporativo inventario=new InventarioCorporativo(); // Para não retornar objeto null
					request.setAttribute("inventario",inventario);
					request.getRequestDispatcher("editarInventario.jsp").forward(request,response);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

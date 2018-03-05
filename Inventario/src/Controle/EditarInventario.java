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
import DAO.ServicoDAO;
import Entidades.InventarioCorporativo;

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
			String arquivoPropriedades=path+"propriedades.txt";
			ServicoDAO dao= ServicoDAO.getInstace(arquivoPropriedades);
			
			//ObterConexao tem que ser fornecido por um controle de acesso.
			
			Connection conn=dao.obterConexao();
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
	

}

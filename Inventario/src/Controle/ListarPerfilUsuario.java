package Controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entidades.Usuario;

/**
 * Servlet implementation class ListarPerfilUsuario
 */
@WebServlet("/listarPerfil")
public class ListarPerfilUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		if (usuario==null) {
			response.sendRedirect("/Inventario/login.jsp");
		}
		else {
			
			request.setAttribute("usuario", usuario);
			response.sendRedirect("/Inventario/protegido/usuario/usuario.jsp");
		}
	}

}

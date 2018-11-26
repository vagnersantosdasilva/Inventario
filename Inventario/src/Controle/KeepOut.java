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
 * Servlet implementation class KeepOut
 */
@WebServlet(description = "Retirar Usuário de Sessão", urlPatterns = { "/keepout" })
public class KeepOut extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		HttpServletResponse res = (HttpServletResponse)response;
		HttpServletRequest req =(HttpServletRequest) request;
		
		Usuario usuario = (Usuario)session.getAttribute("usuario");
		if (usuario!=null) session.setAttribute("usuario", null);
		res.sendRedirect("/Inventario/login.jsp");
	}

	

}

package Controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/removerUsuario")
public class RemoverUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String codigo_usuario=request.getParameter("codigo_usuario");
		 
		 response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
		 response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
		 response.getWriter().write("Teste");
		 System.out.println("Recebido parametro :"+codigo_usuario);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

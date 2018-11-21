package Controle;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.Maquinas;
import DAO.PropriedadesJDBCDAO;
import DAO.PropriedadesSGBDDAO;
import DAO.ServicoDAO;
import Entidades.Maquina;
import Entidades.Propriedades;
import Entidades.PropriedadesJDBC;
import Entidades.PropriedadesSGBD;


/**
 * Servlet implementation class ListarMaquinas
 */
@WebServlet(name = "listarMaquinas", urlPatterns = { "/listarMaquinas" })
public class ListarMaquinas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		try
		{
				ServletContext context = request.getServletContext(); 
				String path = context.getRealPath("/");
				Propriedades propriedades = obterPropriedades(path);
				ServicoDAO servico = ServicoDAO.getInstace(propriedades);
				Connection conn= servico.obterConexao();
				String listar = request.getParameter("filtro");
				Maquinas maquinas =Maquinas.getInstance();
				
				List<Maquina> lista=(List<Maquina>) maquinas.getListaDeMaquinas();
				
				if (listar.equals("relatorio"))
				{
					maquinas.limparListas();
					maquinas.setTotalMaquinas(conn);
					maquinas.setMaquinasComInventario(conn);
					maquinas.setMaquinasSemInventario();
					maquinas.setMaquinasComPendencias(conn);
					request.setAttribute("maquinas",maquinas);
					request.getRequestDispatcher("/protegido/relatorioParcial.jsp").forward(request,response);
				}
				if (listar.equals("todos"))
				{
					maquinas.limparListas();
					maquinas.setListaDeMaquinas(conn);
					request.setAttribute("maquinas",maquinas);
					request.getRequestDispatcher("/protegido/listagemDeMaquinas.jsp").forward(request,response);
				}
				if (listar.equals("semInventarios"))
				{
					maquinas.limparListas();
					maquinas.setListaDeMaquinasSemInventario(conn);
					request.setAttribute("maquinas",maquinas);
					request.getRequestDispatcher("/protegido/listagemDeMaquinasSemInventario.jsp").forward(request,response);
				}
				if (listar.equals("comInventario"))
				{
					maquinas.limparListas();
					maquinas.setListaDeMaquinasComInventario(conn);
					request.setAttribute("maquinas",maquinas);
					request.getRequestDispatcher("/protegido/listagemDeMaquinasComInventario.jsp").forward(request,response);
				}
				if(listar.equals("comPendencias"))
				{
					if(maquinas.getListaDeMaquinasComInventario().size()==0 || (maquinas.getListaDeMaquinasComInventario().equals(null)))
					{
						maquinas.limparListas();
						maquinas.setListaDeMaquinasComInventario(conn);
						maquinas.setListaDeMaquinasComPendencias(maquinas.getListaDeMaquinasComInventario());
						request.setAttribute("maquinas",maquinas);
						request.getRequestDispatcher("/protegido/listagemDeMaquinasComPendencias.jsp").forward(request,response);
					}
					maquinas.limparListas();
					maquinas.setListaDeMaquinasComInventario(conn);
					maquinas.setListaDeMaquinasComPendencias(maquinas.getListaDeMaquinasComInventario());
					request.setAttribute("maquinas",maquinas);
					request.getRequestDispatcher("/protegido/listagemDeMaquinasComPendencias.jsp").forward(request,response);
				}
		}
		catch(Exception e)
		{
			System.out.println("Erro[ListarMaquinas :]"+e.getMessage());
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

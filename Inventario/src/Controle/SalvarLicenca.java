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
import DAO.LicencasDAO;
import DAO.PropriedadesJDBCDAO;
import DAO.PropriedadesSGBDDAO;
import DAO.ServicoDAO;
import Entidades.Licenca;
import Entidades.Propriedades;
import Entidades.PropriedadesJDBC;
import Entidades.PropriedadesSGBD;
import Entidades.Usuario;

@WebServlet("/SalvarLicenca")
public class SalvarLicenca extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
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
					System.out.println("Erro[Servlet - SalvarLicenca]:"+e.getMessage());
					response.sendRedirect("/retornoErro.jsp");
				}
			}
			
			Licenca licenca = new Licenca();
			String contexto=request.getParameter("funcao");
	   		String hostname=request.getParameter("hostname");
	   		licenca.setCodigoMaquina(request.getParameter("codigoMaquina"));
	   		licenca.setNomeSoftware(request.getParameter("produto"));
	   		licenca.setChave(request.getParameter("chave"));
	   		licenca.setDataExpiracao(request.getParameter("data"));
	   		
	   		ServletContext context = request.getServletContext(); 
			String path = context.getRealPath("/");
			Propriedades propriedades = obterPropriedades(path);
	   		
			if (licenca.equals(null))
	   		{
	   			response.sendRedirect("erro.jsp");
			}
			try
			{
				ServicoDAO servico = ServicoDAO.getInstace(propriedades);
				Connection conn= servico.obterConexao();
				LicencasDAO dao = new LicencasDAO();
				if (contexto.equals("editar"))
				{
					if (dao.atualizarRegistro(conn, licenca))
					{
						System.out.println("Sera executado atualizarRegistro(licenca)");
						conn.commit();
						conn.close();
					}
					else
					{
						System.out.println("Não foi possível atualizar o registro de licença. ");
						conn.close();
					}
				}
				if(contexto.equals("incluir"))
				{
					if(dao.incluir(conn, licenca))
					{
						System.out.println("Sera executado incluir(licenca)");
						conn.commit();
						conn.close();
					}
					else
					{
						System.out.println("Não foi possível incluir o registro de licença. ");
						conn.close();
					}
				}
				if (contexto.equals(null))
				{
					System.out.println("Erro [Funçao não definida]");
				}
			}
			catch(Exception e)
			{
				System.out.println("Erro[SalvarInventario["+e.getMessage()+"]");
				e.printStackTrace();
			}
			response.sendRedirect("/Inventario/buscar?procurar="+hostname+"#sessao3");
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

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
import DAO.Maquinas;
import DAO.PropriedadesJDBCDAO;
import DAO.PropriedadesSGBDDAO;
import DAO.ServicoDAO;
import Entidades.Licenca;
import Entidades.Maquina;
import Entidades.Propriedades;
import Entidades.PropriedadesJDBC;
import Entidades.PropriedadesSGBD;
import Entidades.Usuario;

/**
 * Servlet implementation class TransferirLicenca
 */
@WebServlet("/TransferirLicenca" )
public class TransferirLicenca extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	/* Receber registro de origem   e hostname de destino
	 * 
	 * Encontrar codigo de maquina de hostname de destino e montar objeto licenca de destino 
	 * 
	 * Excluir objeto de origem no banco 
	 * Incluir objeto de destino no banco 
	 * 
	 * */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("requisição recebida");
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
		
		Licenca licencaDestino = new Licenca();
		Licenca licencaOrigem = new Licenca();
		String contexto=request.getParameter("funcao");
   		String hostname=request.getParameter("hostname");
   		String hostnameDeDestino = request.getParameter("maquinadestino");
   		licencaOrigem.setCodigoMaquina(request.getParameter("codigoMaquina"));
   		licencaOrigem.setNomeSoftware(request.getParameter("produto"));
   		licencaOrigem.setChave(request.getParameter("chave"));
   		licencaOrigem.setDataExpiracao(request.getParameter("data"));
   		
   		ServletContext context = request.getServletContext(); 
		String path = context.getRealPath("/");
		Propriedades propriedades = obterPropriedades(path);
		
		
		System.out.println("Hostname :"+hostname);
		System.out.println("MaquinaDestino :"+hostnameDeDestino);
		System.out.println("codigoMaquina origem :"+licencaOrigem.getCodigoMaquina());
		System.out.println("Nome do software :"+licencaOrigem.getNomeSoftware());
		System.out.println("Chave :"+licencaOrigem.getChave());
		System.out.println("Data  :"+licencaOrigem.getDataExpiracao());
		
		
		
		if (licencaOrigem.equals(null))
   		{
   			response.sendRedirect("erro.jsp");
		}
		try
		{
			ServicoDAO servico = ServicoDAO.getInstace(propriedades);
			Connection conn= servico.obterConexao();
			Maquinas maquina =Maquinas.getInstance();
			Maquina maquinaDestino = maquina.buscarMaquinaPorHostName(conn, hostnameDeDestino);
			
			String codigoMaquinaDestino = maquinaDestino.getCodigoMaquina();
			if (!codigoMaquinaDestino.equals(null))
			{
				licencaDestino.setCodigoMaquina(codigoMaquinaDestino);
				licencaDestino.setNomeSoftware(licencaOrigem.getNomeSoftware());
				licencaDestino.setChave(licencaOrigem.getChave());
				licencaDestino.setDataExpiracao(licencaOrigem.getDataExpiracao());
			}
			
			
			LicencasDAO dao = new LicencasDAO();
			if ((dao.excluir(conn, licencaOrigem)) &&  (dao.incluir(conn, licencaDestino)))
			{
					System.out.println("Sera executado excluir(licenca)");
					System.out.println("Sera executado incluir(licenca)");
					conn.commit();
					conn.close();
			}
			else
			{
					System.out.println("Não foi possível atualizar o registro de licença. ");
					conn.rollback();
					conn.close();
			}
		
		}
		catch(Exception e)
		{
			System.out.println("Erro[TransferirLicenca["+e.getMessage()+"]");
			e.printStackTrace();
			
			
		}
		response.sendRedirect("/Inventario/buscar?procurar="+hostname);
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

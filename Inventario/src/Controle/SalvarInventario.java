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
import DAO.InventarioDAO;
import DAO.PropriedadesJDBCDAO;
import DAO.PropriedadesSGBDDAO;
import DAO.ServicoDAO;
import Entidades.InventarioCorporativo;
import Entidades.Propriedades;
import Entidades.PropriedadesJDBC;
import Entidades.PropriedadesSGBD;
import Entidades.Usuario;

@WebServlet("/SalvarInventario")
public class SalvarInventario extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		ServletContext context = request.getServletContext(); 
		String path = context.getRealPath("/");
		Propriedades propriedades = obterPropriedades(path);
		
		InventarioCorporativo inventario = new InventarioCorporativo();
   		
   		String contexto=request.getParameter("funcao");
   		inventario.setCodigoMaquina(request.getParameter("codigoMaquina"));
   		inventario.setHostname(request.getParameter("hostname"));
   		inventario.setPatrimonio(request.getParameter("patrimonio"));
   		inventario.setSerial(request.getParameter("serial"));
   		inventario.setFabricante(request.getParameter("fabricante"));
   		inventario.setModeloEquipamento(request.getParameter("modeloEquipamento"));
   		inventario.setResponsavel(request.getParameter("responsavel"));
   		inventario.setDepartamento(request.getParameter("departamento"));
   		inventario.setEmailResponsavel(request.getParameter("email"));
   		inventario.setLoginResponsavel(request.getParameter("login"));
   		inventario.setTelefone(request.getParameter("telefone"));
   		
		System.out.println(inventario.getCodigoMaquina());
		System.out.println(inventario.getHostname());
		System.out.println("Função recebida :"+contexto);
   		System.out.println("Requisição recebida:[SalvarInventario]");	
		if (inventario.equals(null)){
				System.out.println("Erro registrado");
				response.sendRedirect("erro.jsp");
			}
		else
		{
			try
			{
				ServicoDAO servico = ServicoDAO.getInstace(propriedades);
				Connection conn= servico.obterConexao();  //Provisóriamente até criar acesso via web.
				InventarioDAO dao = new InventarioDAO();
				if(dao.existe(conn,inventario.getCodigoMaquina(),inventario.getHostname()))
				{
					if (dao.atualizarRegistro(conn, inventario))
					{
						System.out.println("Executado :atualizarRegistro[SalvarInventario]");
						conn.commit();
						
						conn.close();
					}
				}
				else
				{
					if(dao.incluir(conn, inventario))
					{
						System.out.println("Executado :incluir[SalvarInventario]");
						conn.commit();
						conn.close();
					}
				}
				
				if (contexto.equals(null))
				{
					System.out.println("Erro [Fun��o n�o definida]");
				}
			
				
			}catch(Exception e)
			{
				System.out.println("Erro[SalvarInventario["+e.getMessage()+"]");
				e.printStackTrace();
			}
				response.sendRedirect("/Inventario/buscar?procurar="+inventario.getHostname()+"#sessao0");
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

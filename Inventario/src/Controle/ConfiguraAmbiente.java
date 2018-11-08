package Controle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import DAO.ConfigAmbienteDAO;
import DAO.PropriedadesJDBCDAO;
import DAO.PropriedadesSGBDDAO;
import Entidades.PropriedadesSGBD;
import Util.Cripto;


/**
 * Servlet implementation class ConfiguraAmbiente
 */
@WebServlet(description = "Instalação de Tabelas e arquivos de configurações da aplicação", urlPatterns = { "/ConfiguraAmbiente" })
public class ConfiguraAmbiente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		String driver="";
		String urlConexao="";
		
		try 
		{
			/*Escrever informações nos arquivos de propriedades*/
			String caminhoAplicacao=request.getParameter("caminhoAplicacao");
			String enderecoBanco =request.getParameter("enderecoBanco"); 
			String nomeBanco=request.getParameter("db");
			String email=request.getParameter("email");
			String nomeUsuario = request.getParameter("nomeUsuario");
			String senha=request.getParameter("acesso");
			
			String[] propriedades = {nomeBanco,nomeUsuario,senha,enderecoBanco};
			
			
			/*Escreve o caminho da aplicação no arquivo locais.cfg*/
			String localAplicacao = caminhoAplicacao+"\\WebContent\\WEB-INF\\propriedades\\locais.cfg";
			Util.Propriedades.escrevePropriedades("localAplicacao", caminhoAplicacao, localAplicacao);
			System.out.println("[ESCOPO:ConfiguraAmbiente]:Arquivo de configuração locais.cfg gravado");
			
			/*Define outros locais importantes*/
			String absoluto_jdbc = caminhoAplicacao+"\\WebContent\\WEB-INF\\propriedades\\jdbc.cfg";
			String absoluto_sgbd = caminhoAplicacao+"\\WebContent\\WEB-INF\\propriedades\\bd.cfg";
			String script_estruturas = caminhoAplicacao+"\\WebContent\\WEB-INF\\estruturas\\estruturas.scp";
			String status = caminhoAplicacao+"\\WebContent\\WEB-INF\\propriedades\\status.cfg";
			Util.Propriedades.escrevePropriedades("status", "parcial", status);
			PropriedadesSGBDDAO sgbddao = new PropriedadesSGBDDAO(absoluto_sgbd);
			PropriedadesJDBCDAO jdbcdao = new PropriedadesJDBCDAO(absoluto_jdbc);
			
			//NecessÃ¡rio a posteriori carregar o objeto infobanco com as informaÃ§Ãµe do banco e passar para o dao.
			
			urlConexao = jdbcdao.obterURLConexao(enderecoBanco,  nomeBanco);
			driver = jdbcdao.obterDriver(nomeBanco);
			try
			{
				Class.forName(driver);
				Connection conn = DriverManager.getConnection(urlConexao,nomeUsuario,senha);
				conn.setAutoCommit(true);
				try 
				{
					
					ConfigAmbienteDAO dao = new ConfigAmbienteDAO();
					if (dao.criarBaseDeDados(conn, "inventario",nomeBanco)) 
					{
						
						//conn.commit();
						conn.close();
						
						//Nova conexÃ£o , dessa vez direto com a db criada 
						Class.forName(driver);
						Connection conn2 = DriverManager.getConnection(urlConexao+"/inventario",nomeUsuario,senha);
						conn2.setAutoCommit(false);
						if (dao.criarTabelas(conn2,script_estruturas)) 
						{
							
							if (dao.criarRoot(conn2, email, "?")) System.out.println("[ESCOPO:ConfiguraAmbiente]:Criado usuario admin");
							else System.out.println("[ESCOPO:ConfiguraAmbiente]:NÃ£o foi criado usuario admin nesse contexto");
							conn2.commit();
							System.out.println("[ESCOPO:ConfiguraAmbiente]:Tabelas criadas e gravadas em BD");
							conn2.close();
							
							sgbddao.gravarPropriedades(listaSGBD(propriedades));
							System.out.println("[ESCOPO:ConfiguraAmbiente]:Arquivo de bd.cfg gravado");
							System.out.println("[ESCOPO:ConfiguraAmbiente]:Fim de processo de criação de estruturas");
							Util.Propriedades.escrevePropriedades("status", "ok", status);
							session.setAttribute("mensagem","5");
							response.sendRedirect("/Inventario/config/config.jsp");
						}
					}
				}catch(SQLException e) 
				{
					System.out.println("ConfiguraAmbiente[Erro ao chamar criarBaseDados] :"+e.getMessage());
					session.setAttribute("mensagem", "2");  //Erro de criaÃ§Ã£o de banco e tabelas
					e.printStackTrace();
					response.sendRedirect("/Inventario/config/config.jsp");
				}
				catch(FileNotFoundException e) 
				{
					System.out.println("ConfiguraAmbiente[Um caminho especificado não foi encontrado] :"+e.getMessage());
					e.printStackTrace();
					session.setAttribute("mensagem", "3");  //Erro de criaÃ§Ã£o de banco e tabelas
					response.sendRedirect("/Inventario/config/config.jsp");
				}
				catch(IOException e) 
				{
					System.out.println("ConfiguraAmbiente[Erro I/O .Ao tentar acessar arquivo script de criação de tabelas] :"+e.getMessage());
					e.printStackTrace();
					session.setAttribute("mensagem", "4");  //Erro de criaÃ§Ã£o de banco e tabelas
					response.sendRedirect("/Inventario/config/config.jsp");
				}
				
			}
			catch(SQLException e) 
			{
				session.setAttribute("mensagem", "1");
				System.out.println("Erro[ConfiguraAmbiente:doPost]Carregamento de Driver : "+e.getMessage());
				e.printStackTrace();//codigo referente a erro de acesso ao banco
				response.sendRedirect("/Inventario/config/config.jsp");
			}
		}
		catch(Exception e) 
		{
			session.setAttribute("mensagem", "3");  //Erro em processamento no Servlet
			System.out.println("Erro[ConfguraAmbiente]doPost : "+e.getMessage());
			e.printStackTrace();
			response.sendRedirect("/Inventario/config/config.jsp");
		}
	}
	
	private List<String> listaSGBD(String[] propriedades) 
	{
		
		Cripto cripto = new Cripto(3,2,5,7,13,21,1);
		List<String> lista = new ArrayList<String>();
		lista.add("\n");
		lista.add("usuario="+propriedades[1]);
		lista.add("senha="+cripto.cifrar(propriedades[2]));
		lista.add("sgbdescolhido="+propriedades[0]);
		lista.add("servidor=//"+propriedades[3]+":");
		lista.add("codificacao=UTF-8");
		lista.add("nomeDoBanco=/inventario");
		
		return lista;
	}

}

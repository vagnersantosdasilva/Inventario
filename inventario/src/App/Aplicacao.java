package App;

import java.sql.Connection;
import Controle.Atendente;
import Controle.Servidor;
import DAO.Maquinas;
import DAO.PropriedadesJDBCDAO;
import DAO.PropriedadesSGBDDAO;
import DAO.ServicoDAO;
import Entidades.Propriedades;
import Entidades.PropriedadesJDBC;
import Entidades.PropriedadesSGBD;

public class Aplicacao 
{
	public static void main(String[] args)
	{
		try 
		{
			int porta = 1050;
			Propriedades propriedades = obterPropriedades("locais.cfg");
			ServicoDAO dao =ServicoDAO.getInstace(propriedades);
			Connection conn =dao.obterConexao();
			Maquinas maquinas = Maquinas.getInstance();
			Atendente atendente1 =Atendente.getInstance(conn);
			
			//Produtor
			Servidor servidor1 = new Servidor(atendente1,porta);
			servidor1.start();
			
			Servidor servidor2 = new Servidor(atendente1,1051);
			servidor2.start();
			
			Servidor servidor3 = new Servidor(atendente1,1052);
			servidor3.start();
			
			Servidor servidor4 = new Servidor(atendente1,1053);
			servidor4.start();
			
			Servidor servidor5 = new Servidor(atendente1,1054);
			servidor5.start();
			
			Servidor servidor6 = new Servidor(atendente1,1055);
			servidor6.start();
			
			Servidor servidor7 = new Servidor(atendente1,1056);
			servidor7.start();
			
			//consumidor		
			maquinas.setAtendente(atendente1);
			maquinas.start();
			
			System.out.println("Numero de Atendentes :"+atendente1.getIDAtendente());
					
		}
		catch(Exception e)
		{
			System.out.println("Erro:Servidor:main"+e.getMessage());
			e.printStackTrace();
		}
		System.out.println("Aplicação chamou todos os Threads...");
	}
	private static Propriedades obterPropriedades(String path) 
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

package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Controle.Atendente;
import Entidades.Maquina;
import Entidades.SO;
import Entidades.Software;
import Entidades.CPU;
import Entidades.Hardware;
import Entidades.InventarioCorporativo;


/**************************Nota Sobre codigoMaquina**************************
 * O códigoMaquina será gerado pelo cliente a partir de seu endereço mac 
 * O servidor vai verificar se já existe máquina com o mesmo código
 * Se existir  o servidor atualizará o registro caso seja solicitado
 * Se não existir , o servidor realizará a primeira inclusão no banco.
 * **************************************************************************/

/****************************************************************************
 * Como atualizar o banco quando um componente é retirado de uma lista?
 * Por exemplo Quando um novo software for instalado e outr for removido 
 * 
 * ***************************************************************************/

public class Maquinas extends Thread
{
	private List<Maquina> listaDeMaquinas =new ArrayList<Maquina>();
	private List<Maquina> listaDeMaquinasSemInventario = new ArrayList<Maquina>();
	private List<Maquina> listaDeMaquinasComInventario= new ArrayList<Maquina>();
	private ArmazenamentoDAO armazenamentoDAO = new ArmazenamentoDAO();
	private CPUDAO cpuDAO = new CPUDAO();
	private MemoriasDAO memoriasDAO = new MemoriasDAO();
	private PlacaMaeDAO placaDAO = new PlacaMaeDAO();
	private SoftwareDAO softwareDAO = new SoftwareDAO();
	private InventarioDAO inventarioDAO = new InventarioDAO();
	private LicencasDAO licencasDAO = new LicencasDAO();
	private SODAO soDAO = new SODAO();
	private int totalMaquinas,maquinasComInventario,maquinasSemInventario,maquinasComPendencias=-1;
	private List<Maquina> listaDeMaquinasComPendencias=new ArrayList<Maquina>();
	private static Maquinas instance;
	private Atendente atendente;
	
	private Maquinas()
	{
		 
	}
	
	public static Maquinas getInstance()
	{
		if (instance==null) 
		{
			synchronized(Maquinas.class)
			{
				if (instance==null)
				{
					instance=new Maquinas();
				}
				
			}
			
		} 
		return instance;
	}
	
	public synchronized boolean  incluir(Connection conn,Maquina unidade) 
	{
		try
		{
			armazenamentoDAO.incluir(conn, unidade.getHardware().getListaUnidadesArmazenamento());
			
			if(cpuDAO.existe(conn, unidade.getHardware().getCpu()))cpuDAO.atualizarRegistros(conn, unidade.getHardware().getCpu());
			else cpuDAO.incluir(conn,unidade.getHardware().getCpu());
			
			
			memoriasDAO.incluir(conn,unidade.getHardware().getListaMemorias());
			
			if(placaDAO.existe(conn,unidade.getHardware().getPlacamae().getCodigoMaquina()))
				placaDAO.atualizarRegistro(conn, unidade.getHardware().getPlacamae());
			else placaDAO.incluir(conn, unidade.getHardware().getPlacamae());
			
			
			softwareDAO.incluir(conn, unidade.getListaSoftwares());
			
			if(soDAO.existe(conn, unidade.getSistemaOperacional().getCodigoMaquina())) 
				soDAO.atualizarRegistro(conn, unidade.getSistemaOperacional());
			else soDAO.incluir(conn, unidade.getSistemaOperacional());
			
		return true;
		}
		catch(Exception e)
		{
			System.out.println("Erro[Maquinas:incluir]:"+e.getMessage());
			e.printStackTrace();
			
		}
		return false;
		
	}
	public boolean incluirLista(Connection conn,List<Maquina> lista)
	{
		try
		{
			for(Maquina maquina:lista)
			{
				incluir(conn,maquina);
			}
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Erro:[Maquinas:incluirLista:]"+e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public Maquina buscarMaquina(Connection conn,String codigoMaquina)
	{	
		Maquina maquina =new Maquina(); 
		Hardware hardware =new Hardware();
		SO so = new SO();
		
		try 
		{
			so = soDAO.obterSistema(conn, codigoMaquina);
			List <Software>listaSoftwares = softwareDAO.listarSoftwares(conn, codigoMaquina);
			maquina.setListaSoftwares(listaSoftwares);
			
			hardware.setListaUnidadeArmazenamento(armazenamentoDAO.buscarUnidades(conn, codigoMaquina));
			hardware.setCpu((CPU)cpuDAO.buscarProcessador(conn, codigoMaquina));
			hardware.setListaDeMemorias(memoriasDAO.buscarUnidades(conn, codigoMaquina));
			hardware.setPlacamae(placaDAO.obterPlacaMae(conn, codigoMaquina));
			maquina.setCodigoMaquina(codigoMaquina);
			maquina.setSistemaOperacional(so);
			maquina.setHostname(so.getHostname());
			maquina.setHardware(hardware);
			
			InventarioCorporativo inventario = inventarioDAO.obterInventario(conn, codigoMaquina);
			List listaDeLicencas = licencasDAO.obterListaLicencas(conn,codigoMaquina);
			
			maquina.setInventario(inventario);
			maquina.setListaLicencas(listaDeLicencas);
			
			System.out.println(maquina.getHostname());
			
			return maquina;
		} 
		catch (SQLException e) 
		{
			System.out.println("Erro:[Maquinas:buscarMaquina]"+e.getMessage());
			e.printStackTrace();
		}
		return maquina;
	}
	
	public Maquina buscarMaquinaPorHostName(Connection conn,String hostname)
	{
		String codigoMaquina =(String)soDAO.obterCodigoMaquinaPorHostName(conn,hostname);
		return buscarMaquina(conn,codigoMaquina);
	}
	
	public boolean existeMaquina(Connection conn,String codigoMaquina)
	{
		try 
		{
			if (soDAO.obterSistema(conn, codigoMaquina)!=null) 
			{
				return true;
			}
		} 
		catch (SQLException e) 
		{
			System.out.println("Maquinas[existeMaquina]:"+e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
	
	public void setListaDeMaquinas(Connection conn)
	{
		try 
		{
			PreparedStatement pstmt = conn.prepareStatement("select codigo_maquina,hostname from sistemaOperacional");
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				do
				{
					Maquina maquina= new Maquina();
					maquina.setCodigoMaquina((rs.getString("codigo_maquina")));
					maquina.setHostname((rs.getString("hostname")));
					listaDeMaquinas.add(maquina);
				}
				while(rs.next());
			}
			
		} 
		catch (SQLException e) 
		{
			System.out.println("Erro[Maquinas:setListaDeMaquinas]"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public List<Maquina> getListaDeMaquinas()
	{
		
		return listaDeMaquinas;
	}
	
	public void adicionarMaquina(Maquina maquina)
	{
		this.listaDeMaquinas.add(maquina);
	}
	
	
	
	public void setTotalMaquinas(Connection conn)
	{
		totalMaquinas=soDAO.obterTotalDeRegistros(conn);
	}

	public int getTotalMaquinas()
	{
		return totalMaquinas;
	}
	
	public void setMaquinasComInventario(Connection conn)
	{
		maquinasComInventario= inventarioDAO.obterTotalDeInventarios(conn);
	}
	
	public int getMaquinasComInventario()
	{
		return maquinasComInventario;
	}
	
	public void setMaquinasSemInventario()
	{
		maquinasSemInventario=totalMaquinas-maquinasComInventario;
	}
	
	public int getMaquinasSemInventario()
	{
		return maquinasSemInventario;
	}
	public void setMaquinasComPendencias(Connection conn)
	{
		maquinasComPendencias=inventarioDAO.obterNumeroDeMaquinasComPendencias(conn);
	}
	public int getMaquinasComPendencias()
	{
		return maquinasComPendencias;
	}
	public void setListaDeMaquinasComPendencias(List<Maquina> lista)
	{
		for(Maquina maquina:lista)
		{
			InventarioCorporativo inventario = maquina.getInventario();
			if (inventario.getTelefone().equals("")) listaDeMaquinasComPendencias.add(maquina);
			//if (inventario.getTelefone().equals(null)) System.out.println("Pendente encontrada em "+inventario.getHostname());
			//System.out.println(inventario.getHostname()+":"+inventario.getTelefone());
		}
	}
	public List<Maquina>  getListaDeMaquinasComPendencias()
	{
		return listaDeMaquinasComPendencias;
	}
	public void setListaDeMaquinasComInventario(Connection conn)
	{
		try 
		{
			PreparedStatement pstmt = conn.prepareStatement("select codigo_maquina,hostname,responsavel,telefone_responsavel from maquina");
			ResultSet rs = pstmt.executeQuery();
			if (rs.next())
			{
				do 
				{
					InventarioCorporativo inventario = new InventarioCorporativo();
					Maquina maquina = new Maquina();
					inventario.setCodigoMaquina(rs.getString("codigo_maquina"));
					inventario.setHostname(rs.getString("hostname"));
					inventario.setResponsavel(rs.getString("responsavel"));
					inventario.setTelefone(rs.getString("telefone_responsavel"));
					maquina.setCodigoMaquina(inventario.getCodigoMaquina());
					maquina.setHostname(inventario.getHostname());
					maquina.setInventario(inventario);
					listaDeMaquinasComInventario.add(maquina);
					
				}
				while(rs.next());
				rs.close();
				pstmt.close();
				
			}
		} 
		catch (SQLException e) 
		{
			System.out.println("Erro[Maquinas:setListaMaquinasComInventarios]"+e.getMessage());
			e.printStackTrace();
		}
	}
	public List<Maquina> getListaDeMaquinasComInventario()
	{
		return listaDeMaquinasComInventario;
	}

	public void setListaDeMaquinasSemInventario(Connection conn)
	{
		try 
		{
			PreparedStatement pstmt=conn.prepareStatement("select codigo_maquina,hostname from sistemaOperacional "
					+ "where codigo_maquina not in(select codigo_maquina from maquina)");
			ResultSet rs=pstmt.executeQuery();
			if (rs.next())
			{
				do 
				{
					Maquina maquina = new Maquina();
					maquina.setCodigoMaquina(rs.getString("codigo_maquina"));
					maquina.setHostname(rs.getString("hostname"));
					listaDeMaquinasSemInventario.add(maquina);
				}
				while(rs.next());
				rs.close();
				pstmt.close();
			}
			
			
		} catch (SQLException e) 
		{
			System.out.println("Erro[Maquinas:setListaDeMaquinasSemInventario]"+e.getMessage());
			e.printStackTrace();
		}
	}
	public List<Maquina> getListaDeMaquinasSemInventario()
	{
		return listaDeMaquinasSemInventario;
	}
	public void limparListas()
	{
		listaDeMaquinas.clear();
		listaDeMaquinasComInventario.clear();
		listaDeMaquinasSemInventario.clear();
		listaDeMaquinasComPendencias.clear();
	}

	
	
	public void setAtendente(Atendente atendente)
	{
		this.atendente=atendente;
	}
	
	@Override
	public void run()
	{
		while(true)
		{
			System.out.println("Tamanho da fila :"+atendente.getTamanhoFila());
			System.out.println("Aguardando atividade em fila ...");
			atendente.atender();
			
			
		}
	}
	
}

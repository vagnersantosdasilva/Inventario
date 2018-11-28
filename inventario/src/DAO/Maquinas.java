package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Controle.Atendente;
import Entidades.Maquina;
import Entidades.Memoria;
import Entidades.PlacaMae;
import Entidades.SO;
import Entidades.Software;
import Entidades.UnidadeArmazenamento;
import Entidades.CPU;
import Entidades.Cdrom;
import Entidades.Hardware;
import Entidades.HotFixWindows;
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
	private List<Maquina> listaDeMaquinasComPendencias=new ArrayList<Maquina>();
	private ArmazenamentoDAO armazenamentoDAO = new ArmazenamentoDAO();
	private CPUDAO cpuDAO = new CPUDAO();
	private MemoriasDAO memoriasDAO = new MemoriasDAO();
	private PlacaMaeDAO placaDAO = new PlacaMaeDAO();
	private SoftwareDAO softwareDAO = new SoftwareDAO();
	private InventarioDAO inventarioDAO = new InventarioDAO();
	private LicencasDAO licencasDAO = new LicencasDAO();
	private SODAO soDAO = new SODAO();
	private CdromDAO cdDAO = new CdromDAO();
	// private HotFixDAO hotDAO = new HotFixDAO();
	private int totalMaquinas,maquinasComInventario,maquinasSemInventario,maquinasComPendencias=-1;
	
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
			if (unidade!=null) {
				
				Hardware hard = unidade.getHardware();
				List listaDeMemorias = hard.getListaDeMemorias();
				List listaHD = hard.getListaDeUnidadesDeArmazenamento();
				List listaCD  = hard.getListaDeUnidadesDeCDDVD();
				List listaDeSoftware = unidade.getListaDeSoftwares();
				List listaDeAtualizacoes = unidade.getListaDeAtualizacoes();
				List listaDeLogs = unidade.getListaDeLogsDeErro();
				SO so = unidade.getSistemaOperacional();
				CPU processador = hard.getCpu();
				PlacaMae placa = hard.getPlacamae();
				
				if (!(listaDeMemorias.isEmpty())) executarComandosMemoria(conn,listaDeMemorias);
				if(!(listaHD.isEmpty())) executarComandosUnidadeArmazenamento(conn,listaHD);
				if (!(listaCD.isEmpty())) executarComandosCDDVD(conn,listaCD);
				if (!(listaDeSoftware.isEmpty())) executarComandosSoftware(conn,listaDeSoftware);
				if (!(listaDeAtualizacoes.isEmpty())) executarComandosAtualizacoes(conn,listaDeAtualizacoes);
				//if (listaDeLogs.size()>0) executarComandosLogs(listaDelogs);
				if (so!=null) { 
					if(soDAO.existe(conn, so.getCodigoMaquina())) 
						soDAO.atualizarRegistro(conn, so);
					else soDAO.incluir(conn, so);
				}	
				if (processador!=null) {
					if(cpuDAO.existe(conn, processador)) {cpuDAO.atualizarRegistros(conn, processador);}
					else {cpuDAO.incluir(conn,processador);}
				}
				
				if (placa!=null) {
					if (placaDAO.existe(conn, unidade.getCodigoMaquina())) {placaDAO.atualizarRegistro(conn, placa);}
					else {placaDAO.incluir(conn, placa);}
				}
				return true;
		}	
		System.out.println("Tentativa de inclus�o falhou - Objeto Nulo");
		}
		catch(Exception e)
		{
			System.out.println("Erro[Maquinas:incluir]:"+e.getMessage());
			e.printStackTrace();
			
		}
		return false;
		
	}
	
	private void executarComandosAtualizacoes(Connection conn,List<HotFixWindows> listaDeAtualizacoes) throws SQLException {
		List<HotFixWindows> lista = listaDeAtualizacoes;
		for(HotFixWindows hot:lista) {
			if (hot.getComando().equals("incluir")) {}
			if (hot.getComando().equals("excluir")) {}
		}
	}

	private void executarComandosSoftware(Connection conn, List<Software> listaDeSoftware) throws SQLException {
		List<Software> lista = listaDeSoftware;
		for(Software soft:lista) {
			if (soft.getComando().equals("incluir")) {softwareDAO.incluir(conn, soft);}
			if (soft.getComando().equals("excluir")) {softwareDAO.excluirUm(conn, soft.getCodigoMaquina(), soft.getNome());}
		}
	}

	private void executarComandosCDDVD(Connection conn, List<Cdrom> listaCD) throws SQLException {
		List<Cdrom> lista =listaCD;
		for(Cdrom cd :lista) {
			if (cd.getComando().equals("incluir")) {cdDAO.incluir(conn, cd);}
			if (cd.getComando().equals("excluir")) {cdDAO.excluir(conn, cd);}
		}
	}

	private void executarComandosUnidadeArmazenamento(Connection conn, List<UnidadeArmazenamento> listaHD) throws SQLException {
		List<UnidadeArmazenamento> lista = listaHD;
		for(UnidadeArmazenamento hd :lista) {
			if(hd.getComando().equals("incluir")) {armazenamentoDAO.incluir(conn, hd);}
			if(hd.getComando().equals("excluir")) {armazenamentoDAO.excluir(conn, hd.getCodigoMaquina(), hd.getCodigoDrive());}
			
		}
	}

	private void executarComandosMemoria(Connection conn,List<Memoria> listaDeMemorias) {
	
		List<Memoria> lista =listaDeMemorias;
		for (Memoria mem:lista) {
			if (mem.getComando().equals("incluir")) {memoriasDAO.incluir(conn,mem);}
			if (mem.getComando().equals("excluir")) {memoriasDAO.excluir(conn,mem.getCodigoMaquina(),mem.getCodigoSlot());}
			
		}
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
			maquina.setListaDeSoftwares(listaSoftwares);
			hardware.setListaDeUnidadesDeArmazenamento(armazenamentoDAO.buscarUnidades(conn, codigoMaquina));
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
			maquina.setListaDeLicencas(listaDeLicencas);
			
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

package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Entidades.Cdrom;
import Entidades.Software;

public class CdromDAO 
{

	public boolean incluir(Connection conn,Cdrom cdrom)
	{
		try 
		{
			if (existe(conn,cdrom)) {atualizarRegistro(conn,cdrom);}
			else 
			{
				PreparedStatement pstmt = conn.prepareStatement
						("insert into cdrom("
								+ "codigo_maquina,"
								+ "nome,"
								+ "tipo_de_midea,"
								+ "data_instalacao,"
								+ "fabricante,"
								+ "drive_letra,"
								+ "status_drive,"
								+ "indice) "
								+ "values(?,?,?,?,?,?,?,?)"
						);
				pstmt.setString(1, cdrom.getCodigoMaquina());
				pstmt.setString(2, cdrom.getNome());
				pstmt.setString(3,cdrom.getTipoDeMidea());
				pstmt.setString(4,cdrom.getDataInstalacao());
				pstmt.setString(5,cdrom.getFabricante());
				pstmt.setString(6,cdrom.getDrive());
				pstmt.setString(7,cdrom.getStatus());
				pstmt.setInt(8,cdrom.getIndice());
				
				int n=pstmt.executeUpdate();
				pstmt.close();
				return n==1;
			}	
		return false;		
		} 
		catch (SQLException e) 
		{
			System.out.println("Erro:[CdromDAO]:incluir :"+e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean excluir(Connection conn, Cdrom cdrom)
	{
		
		try 
		{
			PreparedStatement pstmt= conn.prepareStatement("delete from cdrom where codigo_maquina=? and indice=?" );
			pstmt.setString(1, cdrom.getCodigoMaquina());
			pstmt.setInt(2, cdrom.getIndice());
			int n=pstmt.executeUpdate();
			pstmt.close();
			return n==1;
		} 
		catch (SQLException e) 
		{
			System.out.println("Erro:[CdromDAO]:excluir"+e.getMessage());
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean atualizarRegistro(Connection conn,Cdrom cdrom)
	{
		try
		{
			PreparedStatement pstmt= conn.prepareStatement("update cdrom set "
					+ "nome=?,"
					+ "tipo_de_midea=?,"
					+ "data_instalacao=?,"
					+ "fabricante=?,"
					+ "drive_letra=?,"
					+ "status_drive=? "
					+ " where codigo_maquina=? "
					+ "and indice=?");
			pstmt.setString(1, cdrom.getNome());
			pstmt.setString(2, cdrom.getTipoDeMidea());
			pstmt.setString(3, cdrom.getDataInstalacao());
			pstmt.setString(4, cdrom.getFabricante());
			pstmt.setString(5, cdrom.getDrive());
			pstmt.setString(6, cdrom.getStatus());
			pstmt.setString(7, cdrom.getCodigoMaquina());
			pstmt.setInt(8, cdrom.getIndice());
			
			int n=pstmt.executeUpdate();
			pstmt.close();
			return n==1;
		}
		catch(SQLException e)
		{
			System.out.println("Erro:[Update:CdromDAO]"+e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
	public List<Cdrom> obterListaCdrom(Connection conn,String codigoMaquina)
	{
		try
		{
			PreparedStatement pstmt = conn.prepareStatement("select * from cdrom where codigo_maquina=?");
			pstmt.setString(1, codigoMaquina);
			ResultSet rs = pstmt.executeQuery();
			List<Cdrom> lista = new ArrayList<Cdrom>();
			if (rs.next())
			{
				Cdrom cd=new Cdrom();
				cd.setCodigoMaquina(rs.getString("codgioMaquina"));
				cd.setDataInstalacao(rs.getString("data_instalacao"));
				cd.setDrive(rs.getString("drive_letra"));
				cd.setFabricante(rs.getString("fabricante"));
				cd.setIndice(rs.getInt("indice"));
				cd.setNome(rs.getString("nome"));
				cd.setStatus(rs.getString("status_drive"));
				cd.setTipoDeMidea(rs.getString("tipo_de_midea"));
				lista.add(cd);
				
			}
			pstmt.close();
			rs.close();
			return lista;
		}
		catch(SQLException e)
		{
			System.out.println("Erro:[obterListaCdrom:CdromDAO]"+e.getMessage());
			e.printStackTrace();
			
		}
		return null;
		
	}
	
	public boolean excluirLista(Connection conn,List<Cdrom> listaDeCDs)
	{
		try
		{
			for(Cdrom cd:listaDeCDs)
			{
				excluir(conn,cd);
			}
			return true;
		}catch(Exception e)
		{
			System.out.println("Erro[CdromDAO:excluirListaCD]"+e.getMessage());
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean incluirLista(Connection conn,List<Cdrom> listaDeCDs)
	{
		try
		{
			for(Cdrom cd:listaDeCDs)
			{
				incluir(conn,cd);
			}
			return true;
		}catch(Exception e)
		{
			System.out.println("Erro[CdromDAO:incluirListaCD]"+e.getMessage());
			e.printStackTrace();
		}
		
		return false;
	}
	public boolean atualizarLista(Connection conn,List<Cdrom>listaDeCDs)
	{
		try
		{
			for(Cdrom cd:listaDeCDs)
			{
				atualizarRegistro(conn,cd);
			}
			return true;
		}catch(Exception e)
		{
			System.out.println("Erro[CdromDAO:atualizarListaCD]"+e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
	private boolean existe(Connection conn,Cdrom cd)
	{
		try
		{
			PreparedStatement pstmt = conn.prepareStatement("select * from cdrom where codigo_maquina=? and indice=?");
			pstmt.setString(1, cd.getCodigoMaquina());
			pstmt.setInt(2, cd.getIndice());
			ResultSet rs = pstmt.executeQuery();
			int cont=0;
			if (rs.next())
			{
				do
				{
					cont=rs.getRow();
				}
				while(rs.next());
				rs.close();
				pstmt.close();
			}
			if(cont>0)return true;
		}
		catch(Exception e)
		{
			System.out.println("Erro[SoftwareDAO:existe]"+e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
	
		
}

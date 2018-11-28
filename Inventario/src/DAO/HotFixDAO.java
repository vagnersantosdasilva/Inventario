package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Entidades.HotFixWindows;


public class HotFixDAO 
{	
	public boolean incluir(Connection conn ,HotFixWindows unidade) 
	{
		try 
		{
			if (existe(conn,unidade)) {atualizar(conn,unidade);}
			else 
			{
				PreparedStatement pstmt = conn.prepareStatement
				(
					"insert into hotfix "
					+ "(codigo_maquina,"
					+ "caption,"
					+ "cs_name,"
					+ "description,"
					+ "fix_comments,"
					+ "hotfix_id,"
					+ "install_date,"
					+ "installed_by,"
					+ "installed_on,"
					+ "nome,"
					+ "service_pack_in_effect,"
					+ "status) "
					+ " values(?,?,?,?,?,?,?,?,?,?,?)"
				);
				
				pstmt.setString(1,unidade.getCodigoMaquina());
				pstmt.setString(2,unidade.getCaption());
				pstmt.setString(3, unidade.getCsName());
				pstmt.setString(4, unidade.getDescription());
				pstmt.setString(5, unidade.getFixComments());
				pstmt.setString(6, unidade.getHotFixID());
				pstmt.setString(7, unidade.getInstallDate());
				pstmt.setString(8, unidade.getInstalledBy());
				pstmt.setString(9, unidade.getInstalledOn());
				pstmt.setString(10, unidade.getCsName());
				pstmt.setString(11, unidade.getServicePackInEffect());
				pstmt.setString(12, unidade.getStatus());
								
				int n=pstmt.executeUpdate();
				pstmt.close();
				return n==1;
			}
			return false;
		}
		catch(SQLException e)
		{
			System.out.println("Erro[HotfixDAO:incluir]"+e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	public boolean atualizar(Connection conn, HotFixWindows unidade) 
	{
		try
		{
			PreparedStatement pstmt = conn.prepareStatement
					(
						"update hotfix set "
							+ "caption=?,"
							+ "cs_name=?,"
							+ "description=?,"
							+ "fix_comments=?,"
							+ "install_date=?,"
							+ "installed_by=?,"
							+ "installed_on=?, "
							+ "nome=?,"
							+ "service_pack_in_effect=?,"
							+ "status=? "
							+ " where codigo_maquina=? "
					        + "and hotfix_id=?"
					);
					
					pstmt.setString(1,unidade.getCaption());
					pstmt.setString(2, unidade.getCsName());
					pstmt.setString(3, unidade.getDescription());
					pstmt.setString(4, unidade.getFixComments());
					pstmt.setString(5, unidade.getInstallDate());
					pstmt.setString(6, unidade.getInstalledBy());
					pstmt.setString(7, unidade.getInstalledOn());
					pstmt.setString(8, unidade.getCsName());
					pstmt.setString(9, unidade.getServicePackInEffect());
					pstmt.setString(10, unidade.getStatus());
					pstmt.setString(11,unidade.getCodigoMaquina());
					pstmt.setString(12, unidade.getHotFixID());
					int n = pstmt.executeUpdate();
					pstmt.close();
					return n==1;
		}
		catch(SQLException e)
		{
			System.out.println("Erro[HotFixDAO:atualizar]"+e.getMessage());
			e.printStackTrace();
		}
		return false;
		
	}

	private boolean existe(Connection conn, HotFixWindows unidade) 
	{
		try
		{
			PreparedStatement pstmt = conn.prepareStatement("select * from hotfix where codigo_maquina=? and hotfix_id=?");
			pstmt.setString(1, unidade.getCodigoMaquina());
			pstmt.setString(2, unidade.getHotFixID());
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
			System.out.println("Erro[HotFixDAO:existe]"+e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
	
	@SuppressWarnings("unused")
	private boolean excluir(Connection conn,HotFixWindows unidade) 
	{
		try 
		{
			PreparedStatement pstmt = conn.prepareStatement("delete from hotfix where codigo_maquina=? and hotfix_id=?");
			pstmt.setString(1, unidade.getCodigoMaquina());
			pstmt.setString(2, unidade.getHotFixID());
			int n=pstmt.executeUpdate();
			return n==1;
		}
		
		catch(SQLException e) 
		{
			System.out.println("Erro[HotFixDAO:excluir]"+e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
	
	@SuppressWarnings("unused")
	private List<HotFixWindows> obterListaDeHotFix(Connection conn,String codigoMaquina)
	{
		try
		{
			PreparedStatement pstmt = conn.prepareStatement("select * from hotfix where codigo_maquina=?");
			pstmt.setString(1, codigoMaquina);
			ResultSet rs = pstmt.executeQuery();
			List<HotFixWindows> lista = new ArrayList<HotFixWindows>();
			if (rs.next())
			{
				HotFixWindows hot=new HotFixWindows();
				hot.setCodigoMaquina(rs.getString("codigoMaquina"));
				hot.setCaption(rs.getString("caption"));
				hot.setCsName(rs.getString("cs_name"));
				hot.setDescription(rs.getString("description"));
				hot.setFixComments(rs.getString("fix_comments"));
				hot.setHotFixID(rs.getString("hotfix_id"));
				hot.setInstallDate(rs.getString("install_date"));
				hot.setInstalledBy(rs.getString("installed_by"));
				hot.setInstalledOn(rs.getString("installed_on"));
				hot.setName(rs.getString("nome"));
				hot.setServicePackInEffect(rs.getString("service_pack_in_effect"));
				hot.setStatus(rs.getString("status"));
				lista.add(hot);
			}
		return lista;	
		}catch(SQLException e) 
		{
			System.out.println("Erro[HotFixDAO:obterListaDeHotFix]"+e.getMessage());
			e.printStackTrace();
		}	
		return new ArrayList<HotFixWindows>();
	}
	
}

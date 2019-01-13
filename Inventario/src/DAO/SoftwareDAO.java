package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Entidades.Software;

/*Receber uma lista de software e salvar no banco de dados 
 * de acordo com a máquina em a mesma foi gerada*/

public class SoftwareDAO 
{
	public boolean incluir(Connection conn ,Software unidade) throws SQLException
	{
		if (existe(conn,unidade)) {atualizarUmSoftware(conn,unidade);}
		else 
		{
			PreparedStatement pstmt = conn.prepareStatement
			(
				"insert into software "
				+ "(codigo_maquina,"
				+ "nome,"
				+ "arquitetura,"
				+ "data_instalacao,"
				+ "install_location,"
				+ "uninstall_location)"
				+ " values(?,?,?,?,?,?)"
			);
			
			pstmt.setString(1,unidade.getCodigoMaquina());
			
			pstmt.setString(2,unidade.getNome());
			pstmt.setString(3, unidade.getArquitetura());
			pstmt.setString(4, unidade.getDataInstalacao());
			pstmt.setString(5, unidade.getInstallLocation());
			pstmt.setString(6, unidade.getUninstallString());
			int n=pstmt.executeUpdate();
			pstmt.close();
			return n==1;
		}
		return false;
	}
	
	public boolean excluirTodos(Connection conn,String codigoMaquina) throws SQLException
	{
		PreparedStatement pstmt = conn.prepareStatement
		(
			"delete from software where codigo_maquina =? "
		);
		pstmt.setString(1, codigoMaquina);
		int n = pstmt.executeUpdate();
		pstmt.close();
		return n==1;
	}
	public boolean excluirUm(Connection conn,String codigoMaquina,String nome)throws SQLException
	{
		PreparedStatement pstmt = conn.prepareStatement
		(
			"delete from software where codigo_maquina=? and nome=?"
		);
		pstmt.setString(1, codigoMaquina);
		pstmt.setString(2, nome);
		int n=pstmt.executeUpdate();
		return n==1;
	}
	
	@SuppressWarnings("null")
	public List<Software> listarSoftwares(Connection conn,String codigoMaquina)throws SQLException
	{
		List<Software> listaDeUnidades = new ArrayList<Software>();
		PreparedStatement pstmt = conn.prepareStatement("select * from software where codigo_maquina=?");
		pstmt.setString(1, codigoMaquina);
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next())
		{
			do
			{
				Software unidade = new Software();
				unidade.setCodigoMaquina(rs.getString("codigo_maquina"));
				unidade.setNome(rs.getString("nome"));
				unidade.setArquitetura(rs.getString("arquitetura"));
				unidade.setDataInstalacao(rs.getString("data_instalacao"));
				unidade.setInstallLocation(rs.getString("install_location"));
				unidade.setUninstallString(rs.getString("uninstall_location"));
				listaDeUnidades.add(unidade);
			}
			while(rs.next());
			rs.close();
			pstmt.close();
			
			return listaDeUnidades;
		}
		return listaDeUnidades;
	}
	
	
	public boolean atualizarUmSoftware(Connection conn, Software unidade)
	{
		try
		{
			PreparedStatement pstmt = conn.prepareStatement
					(
						"update software set "
							+ "arquitetura=?,"
							+ "data_instalacao=?,"
							+ "install_location=?,"
							+ "uninstall_location=? "
							+ " where codigo_maquina=? "
					        + "and nome=?"
					);
					pstmt.setString(1, unidade.getArquitetura());
					pstmt.setString(2,unidade.getDataInstalacao());
					pstmt.setString(3, unidade.getInstallLocation());
					pstmt.setString(4, unidade.getUninstallString());
					pstmt.setString(5, unidade.getCodigoMaquina());
					pstmt.setString(6,unidade.getNome());
					int n = pstmt.executeUpdate();
					pstmt.close();
					return n==1;
		}
		catch(SQLException e)
		{
			System.out.println("Erro[SoftwareDAO:atualizarRegistro]"+e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	public boolean incluir(Connection conn, List<Software> listaSoftwares) {
		
		try
		{
			for(Software software:listaSoftwares)
			{
				if(existe(conn,software)) {atualizarUmSoftware(conn, software);}
				else incluir(conn,software);
			}
		}
		catch(Exception e)
		{
			System.out.println("Erro[SoftwareDAO:incluir]"+e.getMessage());
			e.printStackTrace();
					
		}
		return false;
	}

	private boolean existe(Connection conn,Software software)
	{
		try
		{
			PreparedStatement pstmt = conn.prepareStatement("select * from software where codigo_maquina=? and nome=?");
			pstmt.setString(1, software.getCodigoMaquina());
			pstmt.setString(2, software.getNome());
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

package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import Entidades.InventarioCorporativo;


public class InventarioDAO {

	public boolean incluir(Connection conn,InventarioCorporativo inventario) throws SQLException
	{
		PreparedStatement pstmt = conn.prepareStatement
		(
			"insert into maquina ("
			+ "codigo_maquina,"
			+ "hostname,"
			+ "patrimonio,"
			+ "numero_serie,"
			+ "fabricante,"
			+ "modelo_equipamento,"
			+ "responsavel,"
			+ "departamento_responsavel,"
			+ "login_responsavel,"
			+ "email_responsavel,"
			+ "telefone_responsavel) "
			+ "values(?,?,?,?,?,?,?,?,?,?,?) "                                                                                                                         
		);
		
		pstmt.setString(1,inventario.getCodigoMaquina());
		pstmt.setString(2, inventario.getHostname());
		pstmt.setString(3, inventario.getPatrimonio());
		pstmt.setString(4, inventario.getSerial());
		pstmt.setString(5, inventario.getFabricante());
		pstmt.setString(6, inventario.getModeloEquipamento());
		pstmt.setString(7, inventario.getResponsavel());
		pstmt.setString(8, inventario.getDepartamento());
		pstmt.setString(9, inventario.getLoginResponsavel());
		pstmt.setString(10, inventario.getEmailResponsavel());
		pstmt.setString(11, inventario.getTelefone());
		
		int n=pstmt.executeUpdate();
		pstmt.close();
		return n==1;
	}
	
	public boolean excluir(Connection conn,String codigoMaquina) throws SQLException
	{
		PreparedStatement pstmt = conn.prepareStatement
		(
			"delete from maquina where codigo_maquina=?"
		);
	
		pstmt.setString(1, codigoMaquina);
		int n=pstmt.executeUpdate();
		pstmt.close();
		return n==1;
	}
	public boolean atualizarRegistro(Connection conn,InventarioCorporativo inventario) throws SQLException
	{
		PreparedStatement pstmt = conn.prepareStatement
		(
				"update maquina set hostname=? , "
				+ "patrimonio=?, "
				+ "numero_serie=?, "
				+ "fabricante=?, "
				+ "modelo_equipamento=?, "
				+ "responsavel =?, "
				+ "departamento_responsavel=?, "
				+ "login_responsavel=?,"
				+ "email_responsavel=?,"
				+ "telefone_responsavel=? "
				+ "where codigo_maquina=?"
		);
		
		pstmt.setString(1, inventario.getHostname());
		pstmt.setString(2, inventario.getPatrimonio());
		pstmt.setString(3, inventario.getSerial());
		pstmt.setString(4, inventario.getFabricante());
		pstmt.setString(5, inventario.getModeloEquipamento());
		pstmt.setString(6, inventario.getResponsavel());
		pstmt.setString(7, inventario.getDepartamento());
		pstmt.setString(8, inventario.getLoginResponsavel());
		pstmt.setString(9, inventario.getEmailResponsavel());
		pstmt.setString(10, inventario.getTelefone());
		pstmt.setString(11, inventario.getCodigoMaquina());
		int n = pstmt.executeUpdate();
		pstmt.close();
		return n==1;
	}
	
	@SuppressWarnings("null")
	public InventarioCorporativo obterInventario(Connection conn,String codigoMaquina) throws SQLException
	{
		PreparedStatement pstmt = conn.prepareStatement
		(
				"select * from maquina where codigo_maquina=?"
		);
		pstmt.setString(1, codigoMaquina);
		ResultSet rs=pstmt.executeQuery();
		InventarioCorporativo inventario = new InventarioCorporativo();
		if (rs.next())
		{
			do
			{
				inventario.setCodigoMaquina(rs.getString("codigo_maquina"));
				inventario.setHostname(rs.getString("hostname"));
				inventario.setPatrimonio(rs.getString("patrimonio"));
				inventario.setSerial(rs.getString("numero_serie"));
				inventario.setFabricante(rs.getString("fabricante"));
				inventario.setModeloEquipamento(rs.getString("modelo_equipamento"));
				inventario.setResponsavel(rs.getString("responsavel"));
				inventario.setDepartamento(rs.getString("departamento_responsavel"));
				inventario.setEmailResponsavel(rs.getString("email_responsavel"));
				inventario.setLoginResponsavel(rs.getString("login_responsavel"));
				inventario.setTelefone(rs.getString("telefone_responsavel"));
				
				
			}
			while(rs.next());
			rs.close();
			pstmt.close();
			return inventario;
		}
		return inventario;
	 }
	public boolean existe(Connection conn,String codigoMaquina,String hostname) throws SQLException
	{
		PreparedStatement pstmt=conn.prepareStatement("select codigo_maquina,hostname from maquina where codigo_maquina=? and hostname=?");
		pstmt.setString(1, codigoMaquina);
		pstmt.setString(2, hostname);
		ResultSet rs=pstmt.executeQuery();
		
		if (rs.next())
		{
			do
			{
				if (((rs.getString("codigo_maquina").equals(codigoMaquina)) && (rs.getString("hostname").equals(hostname)))) return true;
			}
			while(rs.next());
		}	
		return false;
	}

	public List<InventarioCorporativo> pesquisarEmInventarios(Connection conn, String likes) throws SQLException
	{
		PreparedStatement pstmt = conn.prepareStatement
		(
			"select * from maquina where like =?"
		);
		return null;
	}

	public int obterTotalDeInventarios(Connection conn) 
	{
		// TODO Auto-generated method stub
		try 
		{
			PreparedStatement pstmt = conn.prepareStatement("select codigo_maquina from maquina");
			ResultSet rs = pstmt.executeQuery();
			int contador=0;
			if (rs.next())
			{
				do
				{
					contador=contador+1;
				}
				while(rs.next());
				rs.close();
				pstmt.close();
				return contador;
				
			}
			return contador;
		} catch (SQLException e) {
			System.out.println("Erro[InventarioDAO:obterTotalDeInventarios]"+e.getMessage());
			e.printStackTrace();
		}
		return -1;
	}

	public int obterNumeroDeMaquinasComPendencias(Connection conn) {
		
		try 
		{
			int contador=0;
			PreparedStatement pstmt=conn.prepareStatement("select codigo_maquina from maquina where responsavel=? or telefone_responsavel=?");
			pstmt.setString(1, "");
			pstmt.setString(2, "");
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				do
				{
					contador++;
				}while(rs.next());
				rs.close();
				pstmt.close();
				return contador;
			}
			return contador;
		} 
		catch (SQLException e) 
		{
			System.out.println("ERRO[Maquinas:obterNumeroDeMaquinasComPendencias]"+e.getMessage());
			e.printStackTrace();
			
		}
		
		return -1;
	}
	
	
	

}

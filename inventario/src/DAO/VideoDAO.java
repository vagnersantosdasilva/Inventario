package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entidades.Video;

public class VideoDAO 
{
	public boolean incluir(Connection conn,Video video)
	{
		try
		{
			PreparedStatement pstmt = conn.prepareStatement
					("insert into video("
							+ "codigo_maquina,"
							+ "nome,"
							+ "currentHorizontalResolution,"
							+ "currentVerticalResolution,"
							+ "adapterDACType,"
							+ "adapterRAM,"
							+ "currentNumberOfColors,"
							+ "installedDisplayDrivers,"
							+ "driverDate,"
							+ "driverVersion,"
							+ "status_drive)"
							+ "values(?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, video.getCodigoMaquina());
			pstmt.setString(2, video.getNome());
			pstmt.setString(3, video.getCurrentHorizontalResolution());
			pstmt.setString(4, video.getCurrentVerticalResolution());
			pstmt.setString(5, video.getAdapterDACType());
			pstmt.setString(6, video.getAdapterRAM());
			pstmt.setString(7, video.getCurrentNumberOfColors());
			pstmt.setString(8, video.getInstalledDisplayDrivers());
			pstmt.setString(9, video.getDriverDate());
			pstmt.setString(10, video.getDriverVersion());
			pstmt.setString(11, video.getStatus());
			
			int n=pstmt.executeUpdate();
			pstmt.close();
			return n==1;
			
		}
		catch(SQLException e)
		{
			System.out.println("Erro:[VideoDAO:incluir]"+e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean update(Connection conn,Video video)
	{
		try
		{
			PreparedStatement pstmt = conn.prepareStatement("update video set "
					+ "nome=?,"
					+ "currentHorizontalResolution=?,"
					+ "currentVerticalResolution=?,"
					+ "adapterDACType=?,"
					+ "adapterRAM=?, "
					+ "currentNumberOfColors=?,"
					+ "installedDisplayDrivers=?,"
					+ "driverDate=?, "
					+ "driverVersion=?,"
					+ "status_drive=? "
					+ "where codigo_maquina=?");
		}catch(SQLException e)
		{
			System.out.println("Erro:[VideoDAO:update]"+e.getMessage());
			e.printStackTrace();
		}
		
		return false;
	}
	public boolean excluir(Connection conn,String codigoMaquina)
	{
		try
		{
			PreparedStatement pstmt = conn.prepareStatement("delete from video where codigo_maquina=?");
			pstmt.setString(1, codigoMaquina);
			int n=pstmt.executeUpdate();
			pstmt.close();
			return n==1;
		}
		catch(SQLException e)
		{
			System.out.println("Erro:[VideoDAO:excluir]"+e.getMessage());
			e.printStackTrace();
		}
		
		return false;
	}
	public Video getVideo(Connection conn,String codigoMaquina)
	{
		try
		{
			PreparedStatement pstmt = conn.prepareStatement("select * from video where codigo_maquina=?");
			pstmt.setString(1, codigoMaquina);
			ResultSet rs=pstmt.executeQuery();
			if (rs.next())
			{
				Video video;
				do
				{
					video=new Video();
					video.setCodigoMaquina(rs.getString("codigo_maquina"));
					video.setNome(rs.getString("nome"));
					video.setAdapterDACType(rs.getString("adapterDACType"));
					video.setAdapterRAM(rs.getString("adapterRAM"));
					video.setCurrentNumberOfColors(rs.getString("currentNumberOfColors"));
					video.setCurrentHorizontalResolution(rs.getString("currentHorizontalResolution"));
					video.setCurrentVerticalResolution(rs.getString("currentVerticalResolution"));
					video.setStatus(rs.getString("status_drive"));
					video.setDriverVersion(rs.getString("driverVersion"));
					video.setDriverDate(rs.getString("driverDate"));
					video.setInstalledDisplayDrivers(rs.getString("installedDisplayDrivers"));
					
					
				}while(rs.next());
				rs.close();
				pstmt.close();
				return video;
			}
			
		}
		catch(SQLException e)
		{
			System.out.println("Erro:[VideoDAO:getVideo]"+e.getMessage());
			e.printStackTrace();
		}
		
		return new Video();
	}
}

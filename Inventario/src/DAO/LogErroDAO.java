package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entidades.HotFixWindows;
import Entidades.LogErro;


public class LogErroDAO 
{
	public boolean incluir(Connection conn ,LogErro unidade) 
	{
		try 
		{
			if (existe(conn,unidade)) { atualizar(conn,unidade);}
			else 
			{
				PreparedStatement pstmt = conn.prepareStatement
				(
					"insert into evento_erro "
					+ "(codigo_maquina,"
					+ "category,"
					+ "event_code,"
					+ "log_file,"
					+ "message,"
					+ "record_name,"
					+ "source_name,"
					+ "time_generated,"
					+ "type,"
					+ "user)"
					+ " values(?,?,?,?,?,?,?,?,?,?)"
				);
				pstmt.setString(1,unidade.getCodigoMaquina());
				pstmt.setString(2,unidade.getCategory());
				pstmt.setString(3, unidade.getEventCode());
				pstmt.setString(4, unidade.getLogFile());
				pstmt.setString(5, unidade.getMessage());
				pstmt.setString(6, unidade.getRecordNumber());
				pstmt.setString(7, unidade.getSourceName());
				pstmt.setString(8, unidade.getTimeGenerated());
				pstmt.setString(9, unidade.getType());
				pstmt.setString(10, unidade.getUser());
				
				int n=pstmt.executeUpdate();
				pstmt.close();
				return n==1;
			}
			return false;
		}
		catch(SQLException e) 
		{
			System.out.println("Erro[LogErroDAO:incluir]"+e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	public boolean atualizar(Connection conn, LogErro unidade) 
	{
		try
		{
			PreparedStatement pstmt = conn.prepareStatement
					(
						"update evento_erro set "
							+ "category=?,"
							+ "event_code=?,"
							+ "log_file=?,"
							+ "message=?,"
							+ "record_name=?,"
							+ "source_name=?,"
							+ "type=?,"
							+ "user=? "
							+ " where codigo_maquina=? "
					        + "and time_generated=?"
					);
					pstmt.setString(1, unidade.getCategory());
					pstmt.setString(2,unidade.getEventCode());
					pstmt.setString(3, unidade.getLogFile());
					pstmt.setString(4,unidade.getMessage());
					pstmt.setString(5,unidade.getRecordNumber());
					pstmt.setString(6,unidade.getSourceName());
					pstmt.setString(7,unidade.getType());
					pstmt.setString(8,unidade.getUser());
					int n = pstmt.executeUpdate();
					pstmt.close();
					return n==1;
		}
		catch(SQLException e)
		{
			System.out.println("Erro[LogErroDAO:atualizar]"+e.getMessage());
			e.printStackTrace();
		}
		return false;
		
	}

	private boolean existe(Connection conn, LogErro unidade) 
	{
		try
			{
				PreparedStatement pstmt = conn.prepareStatement("select * from evento_erro where codigo_maquina=? and time_generated=?");
				pstmt.setString(1, unidade.getCodigoMaquina());
				pstmt.setString(2, unidade.getTimeGenerated());
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
				System.out.println("Erro[LogErroDAO:existe]"+e.getMessage());
				e.printStackTrace();
			}
			return false;
	}
	public boolean excluir(Connection conn,String codigoMaquina,String data)
	{
		try 
		{
			PreparedStatement pstmt = conn.prepareStatement
					(
						"delete from evento_erro where codigo_maquina=? and time_generated=?"
					);
					pstmt.setString(1, codigoMaquina);
					pstmt.setString(2, data);
					int n=pstmt.executeUpdate();
					return n==1;
		}catch(SQLException e) 
		{
			System.out.println("Erro[LogErroDAO:excluir]"+e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
	
	public List<LogErro> obterLogs(Connection conn,String codigoMaquina) 
	{
		
		try
		{
			PreparedStatement pstmt = conn.prepareStatement("select * from evento_erro where codigo_maquina=?");
			pstmt.setString(1, codigoMaquina);
			ResultSet rs = pstmt.executeQuery();
			List<LogErro> lista = new ArrayList<LogErro>();
			if (rs.next())
			{
				LogErro log = new LogErro();
				log.setCategory(rs.getString("category"));
				log.setEventCode(rs.getString("event_code"));
				log.setLogFile(rs.getString("log_file"));
				log.setMessage(rs.getString("message"));
				log.setRecordNumber(rs.getString("record_name"));
				log.setSourceName(rs.getString("source_name"));
				log.setType(rs.getString("type"));
				log.setUser(rs.getString("user"));
				log.setTimeGenerated(rs.getString("time_generated"));
				log.setCodigoMaquina(rs.getString("codigo_maquina"));
				lista.add(log);
			}
			
			return lista;
		}
		catch(SQLException e) 
		{
			System.out.println("[LogErroDAO:obterLogs] : "+e.getMessage() );
			e.printStackTrace();
			return new ArrayList<LogErro>();
		}
	}

}

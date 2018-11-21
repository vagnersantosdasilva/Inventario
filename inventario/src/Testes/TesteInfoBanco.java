package Testes;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import DAO.BDDAO;
import DAO.ServicoDAO;
import Entidades.BD;

public class TesteInfoBanco {
/*
	@Test
	public void incluirInfoBanco() {
		BD banco =new BD();
		banco.setNomeSGBD("MySQL");
		banco.setNomeBanco("inventario");
		banco.setIpBanco("10.0.0.100");
		banco.setPortaBanco("3306");
		banco.setFrequenciaBackup("Semanalmente");
		banco.setFormatoBackup("SQL");
		banco.setModoBackup("Auto");
		banco.setDataBackup("10/3/2018");
		BDDAO dao = new BDDAO();
		
		ServicoDAO servico;
		try 
		{
				servico = ServicoDAO.getInstace("/home/administrador/Trabalho/ProjetoInventario/Inventario/propriedades.txt");
				Connection conn;
				conn = servico.obterConexao();
				dao.incluir(conn, banco);
				conn.commit();
				conn.close();
		} 
		catch (ClassNotFoundException e) 
		{
				e.printStackTrace();
		}
		catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
	}
*/
}

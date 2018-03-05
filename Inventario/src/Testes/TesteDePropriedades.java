package Testes;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import DAO.InventarioDAO;
import DAO.PlacaMaeDAO;
import DAO.ServicoDAO;
import Entidades.InventarioCorporativo;
import Entidades.PlacaMae;

public class TesteDePropriedades {

	@Test
	public void testeDeUrlBanco() throws IOException, SQLException {
		
		ServicoDAO dao = ServicoDAO.getInstace("propriedades.txt");
		//assertEquals(dao.obterPropriedadesBanco("mysql"),"jdbc:mysql://127.0.0.1:3306/inventario");
		//assertEquals(dao.obterPropriedadesBanco("postgresql"),"jdbc:postgresql://127.0.0.1:5432/inventario");
		String codificado = Util.Propriedades.codificarMD5("abc@123");
		//System.out.println(codificado);
		//Util.Propriedades.escrevePropriedades("servidor", "//10.0.0.100");
	}
	@Test
	public void testarEquidadePropriedades() throws IOException{
		assertEquals(Util.Propriedades.lePropriedades("usuario"),"root");
		assertEquals(Util.Propriedades.lePropriedades("senha"),"abc@123");
	}
	
	@Test
	public void testarQuery() throws IOException, SQLException
	{
		ServicoDAO servico = ServicoDAO.getInstace("propriedades.txt");
		servico.carregarPropriedadesBanco();
		PlacaMaeDAO dao = new PlacaMaeDAO();
		PlacaMae placa =new PlacaMae();
		placa.setCodigoMaquina("1");
		placa.setFabricante("Teste");
		placa.setModelo("Teste");
		try 
		{
			Connection conn=servico.obterConexao();
			assertEquals(true,dao.incluir(conn, placa));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}

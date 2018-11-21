package Testes;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import DAO.InventarioDAO;
import DAO.PlacaMaeDAO;
import DAO.ServicoDAO;
import Entidades.InventarioCorporativo;
import Entidades.PlacaMae;
import Util.Propriedades;

public class TesteDePropriedades {

	@Test
	public void testeDeUrlBanco() throws IOException, SQLException {
		
		//ServicoDAO dao = ServicoDAO.getInstace("propriedades.txt");
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
		//ServicoDAO servico = ServicoDAO.getInstace("propriedades.txt");
		//servico.carregarPropriedadesBanco();
		PlacaMaeDAO dao = new PlacaMaeDAO();
		PlacaMae placa =new PlacaMae();
		placa.setCodigoMaquina("1");
		placa.setFabricante("Teste");
		placa.setModelo("Teste");
		//try 
		//{
			//Connection conn=servico.obterConexao();
			//assertEquals(true,dao.incluir(conn, placa));
		//} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
		//	System.out.println(e.getMessage());
		//} catch (SQLException e) {
			// TODO Auto-generated catch block
		//	System.out.println(e.getMessage());
		//}
	}
	
	/*servidor=//127.0.0.1:
nomeDoBanco=/inventario
sgbdescolhido=mysql
usuario=root
senha=abc@123
codificacao=UTF-8


driverMySql=com.mysql.jdbc.Driver
apiMySql=jdbc:mysql:
portaMySql=3306


driverPostgreSql=org.postgresql.Driver
apiPostgreSql=jdbc:postgresql:
portaPostgreSql=5432
*/
	
	@Test
	public void testarEscreverLista() 
	{
		List<String> lista =new ArrayList<String>();
		lista.add("servidor=//127.0.0.1:");
		lista.add("nomeDoBanco=/inventario");
		lista.add("sgbdescolhido=mysql");
		
		try {
			Propriedades.escreverListaPropriedades(lista, "/home/administrador/Trabalho/ProjetoInventario/Inventario/WebContent/propriedades.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
}

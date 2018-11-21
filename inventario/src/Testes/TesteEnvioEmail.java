package Testes;

import static org.junit.Assert.*;

import org.apache.commons.mail.EmailException;
import org.junit.Test;

import DAO.PropriedadesJDBCDAO;
import DAO.PropriedadesSGBDDAO;
import DAO.PropriedadesSMTPDAO;
import Entidades.ParametrosEmail;
import Entidades.Propriedades;
import Entidades.PropriedadesJDBC;
import Entidades.PropriedadesSGBD;
import Util.Cripto;
import Util.Email;

public class TesteEnvioEmail {

	@Test
	public void testeEnviarEmailPadrao() 
	{
		
		
		
		String smtp ="C:\\Users\\ROGSIM\\Desktop\\Projetos\\ProjetoInventario-Proto\\Inventario\\WebContent\\WEB-INF\\propriedades\\smtp.cfg";
   		PropriedadesSMTPDAO dao = new PropriedadesSMTPDAO(smtp);
   		ParametrosEmail propriedades = dao.obterPropriedades();
   		
   		Cripto cripto = new Cripto(31,13,17,7,2,3,1);
   		System.out.println("Email de origem :"+propriedades.getEmailOrigem());
   		propriedades.setLogin("vagnersantosdasilva");
   		System.out.println("Login :"+propriedades.getLogin());
   		System.out.println("Remetente :"+propriedades.getNomeRemetente());
   		System.out.println("Servidor SMTP :"+propriedades.getSmtp());
   		System.out.println("Porta :"+propriedades.getPorta());
   		propriedades.setSenha("#F2c5h4v7_oxm");
   		
   		System.out.println("Senha:"+propriedades.getSenha());
		
		Email mensagem = new Email(propriedades,"vagnersantosdasilva@gmail.com","Recuperação de Senha S.A.I","Um email de teste ");
		try {
			mensagem.enviarEmail();
		} catch (EmailException e) {
			 //TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package Testes;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.ConnectException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import Entidades.CPU;
import Entidades.Hardware;
import Entidades.Maquina;
import Entidades.Memoria;
import Entidades.PlacaMae;
import Entidades.SO;
import Entidades.Software;
import Entidades.UnidadeArmazenamento;

@SuppressWarnings("serial")
public class MockCliente implements Serializable
{
	private Maquina maquina =new Maquina();
	private List<Software> listaDeSoftwares = new ArrayList<Software>();
	private static int codigo=5;
	private Hardware hardware = new Hardware();
	
	
	//1050  , localhost
	public void montarMaquinaTeste()
	{
		String codigoMaquina=null;
		String hostname=null;
		
		codigo++;
		codigoMaquina=Integer.toString(codigo);
		
		setHardware(codigoMaquina);
		listaDeSoftwares.clear();
		setListaDeSoftware(codigoMaquina);
		
		maquina.setCodigoMaquina(codigoMaquina);
		maquina.setHostname("NAV-WIN"+codigo);
		maquina.setSistemaOperacional(new SO(codigoMaquina,"NAV-WIN"+codigo,"Windows 7","64 bits","6.1","SP1","201711122050","201711171856"));
		maquina.setHardware(hardware);
		maquina.setListaDeSoftwares(listaDeSoftwares);
		
	}
	
	public void enviarMaquina(String servidor,int porta,Maquina maquina)
	{
		try  
		{
			Socket canal = new Socket(servidor,porta);
			OutputStream socketSaida=canal.getOutputStream();
			ObjectOutputStream objeto = new ObjectOutputStream(socketSaida);
			objeto.writeObject(maquina);
			objeto.close();
			canal.close();
			
		}
		catch(ConnectException e)
		{
			System.out.println("Conexão Refutada : Verique conexão e endereço de servidor : "+maquina.getHostname());
			System.out.println("Procedimento de contingência - enviando pela porta 1051");
			//enviarMaquina(servidor,1051,maquina);
		}
		catch(IOException e)
		{
			System.out.println(maquina.getHostname()+" Falhou no envio /"+e.getMessage());
			e.printStackTrace();
		}
	}
	public int receberResposta() {
		
		return 0;
	}
	
	private void setHardware(String codigoMaquina)
	{
		
		hardware.setCpu(new CPU(codigoMaquina,"Phenom II X4", "4", "3200 GHZ","4","AMD","64 bits","OK"));
		hardware.setPlacamae(new PlacaMae(codigoMaquina, "M88-400", "Giga Byte", "A4HJ8K", "OK"));
		hardware.adicionarUnidadeArmazenamento(new UnidadeArmazenamento(codigoMaquina,1,"Sagate","320G","SATA","SCSI","OK"));
		hardware.adicionarMemoria(new Memoria(codigoMaquina,1,"Kingston","4GB","1033","DDR3","OK"));
	}
	
	private void setListaDeSoftware(String codigoMaquina)
	{
		Software software = new Software();
			software.setCodigoMaquina(codigoMaquina);
			software.setNome("Libre Office 5.1");
			software.setArquitetura("64 bits");
			software.setDataInstalacao("10/03/2015");
			listaDeSoftwares.add(software);
			
			
			Software software1 = new Software();
			software1.setCodigoMaquina(codigoMaquina);
			software1.setNome("Microsoft Office 2016");
			software1.setArquitetura("64 bits");
			software1.setDataInstalacao("09/07/2017");
			listaDeSoftwares.add(software1);
			
			
			Software software2 = new Software();
			software2.setCodigoMaquina(codigoMaquina);
			software2.setNome("Bit Defender");
			software2.setArquitetura("64 bits");
			software2.setDataInstalacao("01/07/2014");
			listaDeSoftwares.add(software2);
			
			
			Software software3 = new Software();
			software3.setCodigoMaquina(codigoMaquina);
			software3.setNome("Mozilla Firefox ");
			software3.setArquitetura("64 bits");
			software3.setDataInstalacao("01/07/2014");
			listaDeSoftwares.add(software3);
			
			Software software4 = new Software();
			software4.setCodigoMaquina(codigoMaquina);
			software4.setNome("GNU Octave");
			software4.setArquitetura("64 bits");
			software4.setDataInstalacao("01/07/2014");
			listaDeSoftwares.add(software4);
			
			Software software5 = new Software();
			software5.setCodigoMaquina(codigoMaquina);
			software5.setNome("Scene Builder");
			software5.setArquitetura("64 bits");
			software5.setDataInstalacao("01/07/2014");
			listaDeSoftwares.add(software5);
	}
	
	public Maquina getMaquina()
	{
		return maquina;
	}

	
	
	
}

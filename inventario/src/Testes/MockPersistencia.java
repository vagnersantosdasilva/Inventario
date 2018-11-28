package Testes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import Entidades.CPU;
import Entidades.Hardware;
import Entidades.InventarioCorporativo;
import Entidades.Licenca;
import Entidades.Maquina;
import Entidades.Memoria;
import Entidades.PlacaMae;
import Entidades.SO;
import Entidades.Software;
import Entidades.Som;
import Entidades.UnidadeArmazenamento;
import Entidades.Video;

public class MockPersistencia {
	
	
	private String caminhoDoArquivo;
 	private List<Maquina> repositorio = new ArrayList<Maquina>();
	
 	public void popularBanco(List lista)
 	{
 		
 	}
 	
 	public void popularRepositorio()
 	{
 				 
 			String host1 = "NAV-WIN1";
 			String host2 = "NAV-WIN2";
 			String host3 = "NAV-WIN3";
 			String host4 = "NAV-WIN4";
 			String host5 = "NAV-WIN5";
 			String host6 = "NAV-WIN6";
 			
 			InventarioCorporativo inventario0=new InventarioCorporativo();
 			
 		
 			inventario0.setCodigoMaquina("1");
 			inventario0.setHostname(host1);
 			inventario0.setResponsavel("Vagner da Silva");
 			inventario0.setDepartamento("Vendas");
 			inventario0.setFabricante("ASUS");
 			inventario0.setPatrimonio("CASA092012");
 			inventario0.setSerial("a543k43u");
 			inventario0.setModeloEquipamento("K43U");
 			inventario0.setLoginResponsavel("vss035");
 			inventario0.setEmailResponsavel("vagnersantosdasilva@gmail.com");
 			inventario0.setTelefone("2126025758");
 			
 			InventarioCorporativo inventario2=new InventarioCorporativo();
 			inventario2.setCodigoMaquina("2");
 			inventario2.setHostname(host2);
 			inventario2.setResponsavel("Fulano de Tal");
 			inventario2.setDepartamento("Vendas");
 			inventario2.setFabricante("ASUS");
 			inventario2.setPatrimonio("SALA09334");
 			inventario2.setSerial("a2b2b2b2b2");
 			inventario2.setModeloEquipamento("Inspirion14");
 			inventario2.setLoginResponsavel("fdt012");
 			inventario2.setEmailResponsavel("fulano_de_tal@gmail.com");
 			inventario2.setTelefone("25252525");
 			
 			
 			List<Licenca> listaLicencas = new ArrayList<Licenca>();
 			
 			Licenca licenca = new Licenca();
 			licenca.setCodigoMaquina("1");
 			licenca.setNomeSoftware("Microsoft Office 2003");
 			licenca.setChave("HYDE-09DY-MXH2-JKJK-OPWED");
 			licenca.setDataExpiracao("Nunca Expira");
 			listaLicencas.add(licenca);
 			
 			Licenca licenca2 = new Licenca();
 			licenca2.setCodigoMaquina("2");
 			licenca2.setNomeSoftware("Microsoft Office 2007");
 			licenca2.setChave("YJKM-09DY-MXH2-JKJK-OGHW");
 			licenca2.setDataExpiracao("Nunca Expira");
 			List<Licenca> listaLicencas2 = new ArrayList<Licenca>();
 			listaLicencas2.add(licenca2);
 			
 			
 		    Maquina maquina1 = new Maquina();
 		    Maquina maquina2 = new Maquina();
 		    Maquina maquina3 = new Maquina();
 		    Maquina maquina4 = new Maquina();
 		    Maquina maquina5 = new Maquina();
 		    
 		    maquina1.setCodigoMaquina("1");
 		    maquina1.setHostname(host1);
 		    maquina1.setInventario(inventario0);
 		    maquina1.setListaDeLicencas(listaLicencas);;
 		    
 		    maquina2.setCodigoMaquina("2");
 		    maquina2.setHostname(host2);
 		    maquina2.setInventario(inventario2);
 		    maquina2.setListaDeLicencas(listaLicencas2);
 		    
 		    maquina3.setCodigoMaquina("3");
 		    
 		    maquina3.setHostname(host3);
 		    
 		    maquina4.setCodigoMaquina("4");
 		    maquina4.setHostname(host4);
 		    
 		    maquina5.setCodigoMaquina("5");
 		    maquina5.setHostname(host5);
 		   
 		    
 			SO so = new SO("1","NAV-WIN1","Windows 7","64 bits","6.1","SP1","201711122050","201711171856");
 			SO so1 = new SO("2","NAV-WIN2","Windows 7","64 bits","6.1","SP1","201711122050","201711171856");
 			SO so2 = new SO("3","NAV-WIN3","Windows 7","64 bits","6.1","SP1","201711122050","201711171856");
 			SO so3 = new SO("4","NAV-WIN4","Windows 7","64 bits","6.1","SP1","201711122050","201711171856");
 			SO so4 = new SO("5","NAV-WIN5","Windows 7","64 bits","6.1","SP1","201711122050","201711171856");
 			
 			maquina1.setSistemaOperacional(so);
 			maquina2.setSistemaOperacional(so1);
 			maquina3.setSistemaOperacional(so2);
 			maquina4.setSistemaOperacional(so3);
 			maquina5.setSistemaOperacional(so4);
 			
 			/*  Mauina 1  */
 			Memoria memoria = new Memoria("1",1,"Kingston","4GB","1033","DDR3","OK");
 			Memoria memoria2 = new Memoria("1",2,"Kingston","4GB","1033","DDR3","OK");
 			PlacaMae placa = new PlacaMae("1","M88-400","GigaByte","123549","OK");
 			UnidadeArmazenamento hd0 = new UnidadeArmazenamento("1",1,"Sagate","320G","SATA","SCSI","OK");
 			UnidadeArmazenamento hd1 = new UnidadeArmazenamento("1",2,"Sansung","1T","SATA","SCSI","Falha");
 			CPU cpu = new CPU();
 			cpu.setCodigoMaquina("1");
 			cpu.setNome("Atlhon II X2");
 			cpu.setFabricante("AMD");
 			cpu.setNumeroNucleos("2");
 			cpu.setArquitetura("64");
 			cpu.setFrequenciaMaxima("3200GHz");
 			cpu.setNumeroProcessadoresLogicos("4");
 			
 			Hardware hardware = new Hardware();
 			hardware.setCpu(cpu);
 			hardware.adicionarUnidadeArmazenamento(hd0);
 			hardware.adicionarUnidadeArmazenamento(hd1);
 			hardware.adicionarMemoria(memoria);
 			hardware.adicionarMemoria(memoria2);
 			hardware.setPlacamae(placa);
 				
 			
 			/*  Maquina 2  */
 			Memoria memoria3 = new Memoria("2",1,"Kingston","4GB","1033","DDR3","OK");
 			PlacaMae placa1 = new PlacaMae("2","M88-400","GigaByte","123549","OK");
 			UnidadeArmazenamento hd2 = new UnidadeArmazenamento("2",1,"Sagate","320G","SATA","SCSI","OK");
 			UnidadeArmazenamento hd3 = new UnidadeArmazenamento("2",2,"Maxtor","80G","SATA","SCSI","OK");
 			CPU cpu2 = new CPU();
 			cpu2.setCodigoMaquina("2");
 			cpu2.setNome("Phenom II X4");
 			cpu2.setFabricante("AMD");
 			cpu2.setNumeroNucleos("4");
 			cpu2.setArquitetura("64");
 			cpu2.setFrequenciaMaxima("3200GHz");
 			cpu2.setNumeroProcessadoresLogicos("4");
 			
 			Hardware hardware1 = new Hardware();
 			hardware1.setCpu(cpu2);
 			hardware1.adicionarUnidadeArmazenamento(hd2);
 			hardware1.adicionarUnidadeArmazenamento(hd3);
 			hardware1.adicionarMemoria(memoria3);
 			hardware1.setPlacamae(placa1);
 		
 			
 			/*  Mauina 3  */
 			Memoria memoria4 = new Memoria("3",1,"Kingston","4GB","1033","DDR3","OK");
 			PlacaMae placa2 = new PlacaMae("3","M88-400","GigaByte","123549","OK");
 			UnidadeArmazenamento hd4 = new UnidadeArmazenamento("3",1,"Sagate","320G","SATA","SCSI","OK");
 			CPU cpu3 = new CPU();
 			cpu3.setCodigoMaquina("3");
 			cpu3.setNome("Phenom II X4");
 			cpu3.setFabricante("AMD");
 			cpu3.setNumeroNucleos("4");
 			cpu3.setArquitetura("64");
 			cpu3.setFrequenciaMaxima("3200GHz");
 			cpu3.setNumeroProcessadoresLogicos("4");
 			
 			Hardware hardware2 = new Hardware();
 			hardware2.setCpu(cpu3);
 			hardware2.adicionarUnidadeArmazenamento(hd4);
 			
 			hardware2.adicionarMemoria(memoria4);
 			hardware2.setPlacamae(placa2);
 			
 			/*  Mauina 4  */
 			Memoria memoria5 = new Memoria("4",1,"Kingston","4GB","1033","DDR3","OK");
 			PlacaMae placa4 = new PlacaMae("4","M88-400","GigaByte","123549","OK");
 			UnidadeArmazenamento hd5 = new UnidadeArmazenamento("4",1,"Sagate","320G","SATA","SCSI","OK");
 			CPU cpu4 = new CPU();
 			cpu4.setCodigoMaquina("4");
 			cpu4.setNome("Phenom II X4");
 			cpu4.setFabricante("AMD");
 			cpu4.setNumeroNucleos("4");
 			cpu4.setArquitetura("64");
 			cpu4.setFrequenciaMaxima("3200GHz");
 			cpu4.setNumeroProcessadoresLogicos("4");
 			
 			Hardware hardware3 = new Hardware();
 			hardware3.setCpu(cpu4);
 			hardware3.adicionarUnidadeArmazenamento(hd5);
 			hardware3.adicionarMemoria(memoria5);
 			hardware3.setPlacamae(placa4);
 			
 			/*Maquina 5*/
 			Memoria memoria6 = new Memoria("5",1,"Kingston","4GB","1033","DDR3","OK");
 			PlacaMae placa5 = new PlacaMae("5","M88-400","GigaByte","123549","OK");
 			UnidadeArmazenamento hd6 = new UnidadeArmazenamento("5",1,"Sagate","320G","SATA","SCSI","OK");
 			CPU cpu5 = new CPU();
 			cpu5.setCodigoMaquina("5");
 			cpu5.setNome("Phenom II X4");
 			cpu5.setFabricante("AMD");
 			cpu5.setNumeroNucleos("4");
 			cpu5.setArquitetura("64");
 			cpu5.setFrequenciaMaxima("3200GHz");
 			cpu5.setNumeroProcessadoresLogicos("4");
 			Hardware hardware4= new Hardware();
 			hardware4.setCpu(cpu5);
 			hardware4.adicionarUnidadeArmazenamento(hd6);
 			hardware4.adicionarMemoria(memoria6);
 			hardware4.setPlacamae(placa5);
 			
 			
 			maquina1.setHardware(hardware);
 			maquina2.setHardware(hardware1);
 			maquina3.setHardware(hardware2);
 			maquina4.setHardware(hardware3);
 			maquina5.setHardware(hardware4);
 			
 			Som som = new Som();
 			Video video = new Video();
 			
 			
 			List<Software>lista = new ArrayList<Software>();
 			List<Software>lista1 = new ArrayList<Software>();
 			List<Software>lista2 = new ArrayList<Software>();
 			List<Software>lista3 = new ArrayList<Software>();
 			List<Software>lista4 = new ArrayList<Software>();
 			
 			Software software = new Software();
 			software.setCodigoMaquina("1");
 			software.setNome("Libre Office 5.1");
 			software.setArquitetura("64 bits");
 			software.setDataInstalacao("10/03/2015");
 			lista.add(software);
 			
 			
 			Software software1 = new Software();
 			software1.setCodigoMaquina("1");
 			software1.setNome("Microsoft Office 2016");
 			software1.setArquitetura("64 bits");
 			software1.setDataInstalacao("09/07/2017");
 			lista.add(software1);
 			
 			
 			Software software2 = new Software();
 			software2.setCodigoMaquina("2");
 			software2.setNome("Teste de Lista 3");
 			software2.setArquitetura("64 bits");
 			software2.setDataInstalacao("01/07/2014");
 			lista1.add(software2);
 			
 			
 			Software software3 = new Software();
 			software3.setCodigoMaquina("3");
 			software3.setNome("Teste de Lista 3");
 			software3.setArquitetura("64 bits");
 			software3.setDataInstalacao("01/07/2014");
 			lista2.add(software3);
 			
 			Software software4 = new Software();
 			software4.setCodigoMaquina("4");
 			software4.setNome("Teste de Lista 3");
 			software4.setArquitetura("64 bits");
 			software4.setDataInstalacao("01/07/2014");
 			lista3.add(software4);
 			
 			Software software5 = new Software();
 			software5.setCodigoMaquina("5");
 			software5.setNome("Teste de Lista 3");
 			software5.setArquitetura("64 bits");
 			software5.setDataInstalacao("01/07/2014");
 			lista4.add(software5);
 			
 			maquina1.setListaDeSoftwares(lista);
 			maquina2.setListaDeSoftwares(lista1);
 			maquina3.setListaDeSoftwares(lista2);
 			maquina4.setListaDeSoftwares(lista3);
 			maquina5.setListaDeSoftwares(lista4);
 			
 			repositorio.add(maquina1);
 			repositorio.add(maquina2);
 			repositorio.add(maquina3);
 			repositorio.add(maquina4);
 			repositorio.add(maquina5);
 		
 			
 	}
 	
	public List obterListaDeMaquinas()
	{
		return repositorio;
	}
	//Para atribuição do servidor de buscar máquinas no servidor
	public Maquina buscarMaquina(String hostname)
	{
		
		for (Maquina host :repositorio)
		{
			
			if(host.getHostname().equals(hostname)) return host;
		}
		return null;
	}
	
	public void salvarMaquina(Maquina maquina)
	{
		Gson gson = new Gson();
		if (maquina!=null)
		{	
			String objetoConvertido = gson.toJson(maquina);
			salvarFrase(objetoConvertido,"banco.txt");
		}
		
	}
	
	private void salvarFrase(String frase,String caminho)
	{ 
	
		if(!existePalavraEmArquivo(frase, caminho))
		{
			try 
			{
				Writer arquivo = new BufferedWriter(new FileWriter(caminho, true));
				
				arquivo.append(frase+"\n");
				arquivo.close();
				
			} 
			catch (IOException e) 
			{
				System.out.println("Erro ao tentar gravar dados"); 
			}
		}
			
	}
	
	private boolean existePalavraEmArquivo(String palavra,String caminho)
	{
		try 
		{
			Path arquivo = Paths.get(caminho);
			List <String> linhas = Files.readAllLines(arquivo);
			
			for(String linha:linhas)
			{
				if (linha.indexOf(palavra)>=0) return true;
			}
		} 
		catch (IOException e) 
		{
			System.out.println(e.getMessage());
		}

		return false;
	}
	

}

package Controle;


import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import Entidades.Hardware;
import Entidades.Maquina;
import Entidades.Memoria;

public class Servidor extends  Thread 
{
	private Atendente atendente ;
	private int porta;
	
	 
	
	public Servidor (Atendente atendente,int porta)
	{
		this.atendente=atendente;
		this.porta=porta;
	}
	
	
	
	@Override
	public void run() 
	{
		try 
		{
			@SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(porta);
			while(true)
			{
			
				System.out.println("Aguardando requisição...");
				
				Socket clienteSocket = serverSocket.accept();
				InputStream socketIn = clienteSocket.getInputStream();
				ObjectInputStream objetoEntrada = new ObjectInputStream(socketIn);
				Maquina maquina = (Maquina)objetoEntrada.readObject();
				atendente.adicionar(maquina);
				System.out.print("Usou porta :"+porta);
				
				//Enviando resposta 
				OutputStream socketOut = clienteSocket.getOutputStream();
				DataOutputStream dout = new DataOutputStream(socketOut);
				dout.writeInt(1);
				System.out.println("Enviada resposta para "+maquina.getCodigoMaquina());
				
			} 
		}
		catch (Exception e) 
		{
			System.out.println("Erro[Servidor:run] "+e.getMessage());
			e.printStackTrace();
		}
	}
	
}

package Controle;


import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import Entidades.Maquina;

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
				
			} 
		}
		catch (Exception e) 
		{
			System.out.println("Erro[Servidor:run] "+e.getMessage());
			e.printStackTrace();
		}
	}
	
}

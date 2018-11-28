package Controle;

import java.sql.Connection;
import java.util.List;

import DAO.Maquinas;
import Entidades.Hardware;
import Entidades.Maquina;
import Entidades.Memoria;
import Entidades.UnidadeArmazenamento;
import Estruturas.Fila;

public class Atendente 
{
	private Fila fila = new Fila();
	private Connection conn;
	private Maquinas dao = Maquinas.getInstance();
	private static Atendente  instance;
	private static int numeroAtendentes=0;
	
	
	public int getIDAtendente()
	{
		return numeroAtendentes;
	}
	public static Atendente getInstance(Connection conn)
	{
		if (numeroAtendentes<=5)
			synchronized (Atendente.class)
			{
				if (numeroAtendentes<=5)  
				{
					numeroAtendentes++;
					instance = new Atendente(conn);
					return instance;
				}
			}
		return instance;
	}
	
	private Atendente(Connection conn)
	{
		this.conn=conn;
	
	}
	public synchronized void adicionar(Maquina maquina)
	{
		try 
		{
			if (maquina!=null) {
				System.out.println("Máquina Código "+maquina.getCodigoMaquina() +" inserido em fila...");
				Hardware hard = maquina.getHardware();
				List <Memoria> lista = hard.getListaDeMemorias();
				List <UnidadeArmazenamento> lista_ = hard.getListaDeUnidadesDeArmazenamento();
				System.out.println("Teste de obtençao de memórias");
				for (Memoria mem :lista) {
					System.out.println("Capacidade Mem:"+mem.getCapacidade());
					System.out.println("Comando       :"+mem.getComando());
					System.out.println("Slot       :"+mem.getCodigoSlot());
				}
				
			}
			if(!(fila.estaCheia()))
			{
				fila.inserirNaFila(maquina);
				notifyAll();
			}
			else
			{
				wait();
			}
			
			
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	public synchronized void atender()
	{
		try
		{
			if((fila.getTamanho()>0))
			{
				Maquina unidade = fila.recuperaMaquina();
				if (dao.incluir(conn, unidade))
				{
					conn.commit();
					System.out.println("Mantido : "+unidade.getHostname());
				}
				
				notifyAll();
			}
			else
			{
				wait();
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Erro :[Atendente:atender]"+e.getCause());
			e.printStackTrace();
		}
		
	}
	public boolean estaDisponivel()
	{
		if (fila.estaCheia()) return false;
		return true;
	}
	
	public int getTamanhoFila()
	{
		return fila.getTamanho();
	}
}

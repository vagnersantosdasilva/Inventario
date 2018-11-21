package Estruturas;


import java.util.PriorityQueue;
import java.util.Queue;
import Entidades.Maquina;

public class Fila {
	
	Queue<Maquina> fila = new  PriorityQueue<Maquina>(1000);
	
		
	public boolean estaVazio(){
		if (fila.isEmpty()) return true;
		return false;
	}
	
	public boolean estaCheia()
	{
		if(fila.size()==1000) return true;
		return false;
	}
	
    public boolean inserirNaFila(Maquina maquina)
    {
		if (fila.offer(maquina)) return true; 
		return false;
	}
    
    public Maquina recuperaMaquina() 
    {
    	Maquina maquina =(Maquina)fila.poll();
    	return maquina;
    }
    
    public int getTamanho()
    {
    	return fila.size();
    }
 
}

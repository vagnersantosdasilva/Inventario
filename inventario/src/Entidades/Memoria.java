package Entidades;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Memoria implements Serializable{
	private String codigoMaquina;
	private int codigoSlot;
	private String capacidade;
	private String fabricante;
	private String velocidade;
	private String tipo;
	private String status;
	
	public Memoria(){}
	public Memoria(String codigoMaquina , int codigoSlot,String fabricante,String capacidade,String velocidade,String tipo,String status)
	{
		this.codigoMaquina=codigoMaquina;
		this.codigoSlot=codigoSlot;
		this.fabricante=fabricante;
		this.capacidade=capacidade;
		this.velocidade=velocidade;
		this.tipo=tipo;
	}
	
	public String getCodigoMaquina()
	{
		return codigoMaquina;
	}
	public void setCodigoMaquina(String codigoMaquina)
	{
		this.codigoMaquina=codigoMaquina;
	}
	
	public int getCodigoSlot()
	{
		return codigoSlot;
	}
	
	public void setCodigoSlot(int codigoSlot)
	{
		this.codigoSlot=codigoSlot;
	}
	
	public String getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(String capacidade) {
		this.capacidade = capacidade;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getVelocidade() {
		return velocidade;
	}
	public void setVelocidade(String velocidade) {
		this.velocidade = velocidade;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setStatus(String status){
		this.status=status;
	}
	public String getStatus() {
		// TODO Auto-generated method stub
		return status;
	}
	
	/*public String tamanhoGiga(){
		Double local = (double) Math.round(((total/1024)*(1/1024)));
		
		String tamanhoGiga=local.toString();
		return tamanhoGiga;
	}
	
	public String tamanhoMega(){
		return null;
	}
	*/

	
	
}

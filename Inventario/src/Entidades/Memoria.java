package Entidades;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Memoria implements Serializable{
	private static final long serialVersionUID = 1L;
	private String codigoMaquina;
	private int codigoSlot;
	private String capacidade;
	private String fabricante;
	private String velocidade;
	private String tipo;
	private String status;
	private String comando;
	
	public String getComando() {
		return comando;
	}
	public void setComando(String comando) {
		this.comando = comando;
	}
	
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
	
	public void setCodigoSlot(String codigoSlot)
	{
		this.codigoSlot=converterSlot(codigoSlot);
	}
	
	public void setCodigoSlot(int codigoSlot)
	{
		this.codigoSlot=codigoSlot;
	}
	
	public String getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(String capacidade) {
		
		//String capacidadeGiga=converteByteParaGiga(capacidade);
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
	
//	private String converteByteParaGiga(String total){
//		
//		long giga = Long.parseLong(total); 
//		
//		Double local = (double)(giga/(1024*1024*1024));
//		
//		
//		return local.toString()+" GB";
//	}
	
	
	 private int converterSlot(String slot)
	 {
		 if ((slot.equals("A0")) || (slot.indexOf("DIMM0")>=0)) return 0;
		 if ((slot.equals("A1")) || (slot.indexOf("DIMM1")>=0)) return 1;
		 if ((slot.equals("A2")) || (slot.indexOf("DIMM2")>=0)) return 2;
		 if ((slot.equals("A3")) || (slot.indexOf("DIMM3")>=0)) return 4;
		 if ((slot.equals("B0")) || (slot.indexOf("DIMM4")>=0)) return 5;
		 if ((slot.equals("B1")) || (slot.indexOf("DIMM5")>=0)) return 6;
		 if ((slot.equals("B2")) || (slot.indexOf("DIMM6")>=0)) return 7;
		 if ((slot.equals("B3")) || (slot.indexOf("DIMM7")>=0)) return 8;
		 return 0;
	 }
	 
	 public boolean equals(Memoria memoria)
	 {
		 if ((this.codigoMaquina.equals(memoria.getCodigoMaquina()))&&
				 (this.codigoSlot==memoria.getCodigoSlot())&&
				 ((this.fabricante.equals(memoria.getFabricante()))&&
				 (this.tipo.equals(memoria.getTipo())))&&
				 (this.velocidade.equals(memoria.getVelocidade()))&&
				 (this.capacidade.equals(memoria.getCapacidade()))&&
				 (this.status.equals(memoria.getStatus()))) return true;
		 return false;
	 }
	
}

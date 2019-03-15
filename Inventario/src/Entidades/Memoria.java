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
		return converterTipo(tipo);
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
	 private String converterTipo(String type) {
		 if (tipo.equals ("0")) return "Unknown";
		 if (tipo.equals ("1")) return "Other";
		 if (tipo.equals ("2")) return "DRAM";
		 if (tipo.equals ("3")) return "Synch.DRAM";
		 if (tipo.equals ("4")) return "Cache DRAM";
		 if (tipo.equals ("5")) return "EDO";
		 if (tipo.equals ("6")) return "EDRAM";
		 if (tipo.equals ("7")) return "VRAM";
		 if (tipo.equals ("8")) return "SRAM";
		 if (tipo.equals ("9")) return "RAM";
		 if (tipo.equals ("10")) return "ROM";
		 if (tipo.equals ("11")) return "Flash";
		 if (tipo.equals ("12")) return "EEPROM";
		 if (tipo.equals ("13")) return "FEPROM";
		 if (tipo.equals ("14")) return "EPROM";
		 if (tipo.equals ("15")) return "CDRAM";
		 if (tipo.equals ("16")) return "3DRAM";
		 if (tipo.equals ("18")) return "SDRAM";
		 if (tipo.equals ("19")) return "SGRAM";
		 if (tipo.equals ("20")) return "RDRAM";
		 if (tipo.equals ("21")) return "DDR";
		 if (tipo.equals ("22")) return "DDR2";
		 if (tipo.equals ("23")) return "DDR2FBDIMM";
		 if (tipo.equals ("24")) return "DDR3";
		 if (tipo.equals ("25")) return "FBD2";
		 if (isDDR4(type)) return "DDR4";
		 return type;
		 
	 }
	 private boolean isDDR4(String type) {
		 if (type!=null) {		 
			 int frequencia  =  Integer.parseInt(velocidade);
			 if (frequencia >1600) return true;
		 }
		 return false;
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

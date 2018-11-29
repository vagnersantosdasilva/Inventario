package Entidades;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PlacaMae implements Serializable{
	private static final long serialVersionUID = 1L;
	private String codigoMaquina;
	private String modelo;
	private String fabricante;
	private String serial;
	private String status;
	private String comando;
	
	public String getComando() {
		return comando;
	}
	public void setComando(String comando) {
		this.comando = comando;
	}
	public PlacaMae(){}
	
	public PlacaMae(String codigoMaquina, String modelo,String fabricante,String serial,String status)
	{
		this.codigoMaquina=codigoMaquina;
		this.modelo=modelo;
		this.fabricante=fabricante;
		this.serial=serial;
		this.status=status;
	}

	
	
	public String getCodigoMaquina() {
		return codigoMaquina;
	}



	public void setCodigoMaquina(String codigoMaquina) {
		this.codigoMaquina = codigoMaquina;
	}



	public String getSerial() {
		return serial;
	}



	public void setSerial(String serial) {
		this.serial = serial;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getModelo()
	{
		return modelo;
	}


	public String getFabricante() {
		return fabricante;
	}


	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	
	public boolean equals(PlacaMae placa)
	{
		if((this.codigoMaquina.equals(placa.getCodigoMaquina()))&&
				(this.fabricante.equals(placa.getFabricante())&&
				(this.modelo.equals(placa.getModelo())))&&
				(this.serial.equals(placa.getSerial()))&&
				(this.status.equals(placa.getStatus()))) return true;
		return false;
	}
	
}

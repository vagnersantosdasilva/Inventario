package Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings("serial")
public class Maquina implements Serializable,Comparable<Maquina> {
	
	private String codigoMaquina;
	private String hostname;
	private Hardware hardware;
	private SO sistemaOperacional;
	private InventarioCorporativo inventario;
	private List<Software> listaSoftwares = new ArrayList<Software>();
	private List<Licenca>listaLicencas = new ArrayList<Licenca>();

	public InventarioCorporativo getInventario() {
		return inventario;
	}

	public void setInventario(InventarioCorporativo inventario) {  //não será usado
		this.inventario = inventario;
	}

	public String getCodigoMaquina() {
		return codigoMaquina;
	}

	public void setCodigoMaquina(String codigoMaquina) {
		this.codigoMaquina = codigoMaquina;
	}
	
	public void setHostname(String hostname)
	{
		this.hostname=hostname;
	}
	
	public String getHostname()
	{
		return hostname;
	}
	public Hardware getHardware() {
		return hardware;
	}
	public void setHardware(Hardware hardware) {
		this.hardware = hardware;
	}
	
	public SO getSistemaOperacional() {
		return sistemaOperacional;
	}
	public void setSistemaOperacional(SO sistemaOperacional) {
		this.sistemaOperacional = sistemaOperacional;
	}

	public List<Software> getListaSoftwares() {
		return listaSoftwares;
	}

	public void setListaSoftwares(List<Software> listaSoftwares) {
		this.listaSoftwares = listaSoftwares;
	}

	public List<Licenca> getListaLicencas() {
		return listaLicencas;
	}

	public void setListaLicencas(List<Licenca> listaLicencas) {
		this.listaLicencas = listaLicencas;
	}

	@Override
	public int compareTo(Maquina o) {
		
		if (o.getListaSoftwares().size()==this.listaSoftwares.size()) return 1;
		if (o.getListaSoftwares().size()<=this.listaSoftwares.size()) return 1;
		if (o.getListaSoftwares().size()>this.listaSoftwares.size()) return 0;
		return -1;
	}
	
}

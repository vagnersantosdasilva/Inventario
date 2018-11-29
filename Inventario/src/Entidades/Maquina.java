package Entidades;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Maquina implements Serializable,Comparable<Maquina> {
	private static final long serialVersionUID = 1L;
	private String codigoMaquina;
	private String hostname;
	private Hardware hardware;
	private SO sistemaOperacional;
	private List listaDeSoftwares;
	private List listaDeAtualizacoes;
	private List listaDeLogsDeErro;
	private List listaDeLicencas;
	private InventarioCorporativo inventario;
	
	
	public InventarioCorporativo getInventario() {
		return inventario;
	}

	public void setInventario(InventarioCorporativo inventario) {
		this.inventario = inventario;
	}

	public List getListaDeLicencas() {
		return listaDeLicencas;
	}

	public void setListaDeLicencas(List listaDeLicencas) {
		this.listaDeLicencas = listaDeLicencas;
	}

	private List ListaDeLicencas;
	
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
	public List getListaDeSoftwares() {
		return listaDeSoftwares;
	}

	public void setListaDeSoftwares(List listaDeProgramas) {
		this.listaDeSoftwares = listaDeProgramas;
	}
	
	public List getListaDeAtualizacoes() {
		return listaDeAtualizacoes;
	}

	public void setListaDeAtualizacoes(List listaDeAtualizacoes) {
		this.listaDeAtualizacoes = listaDeAtualizacoes;
	}
	public List getListaDeLogsDeErro() {
		return listaDeLogsDeErro;
	}
	public void setListaDeLogsDeErro(List listaDeLogs) {
		this.listaDeLogsDeErro =listaDeLogs;
		
	}


	public int compareTo(Maquina m) {
		
		if(m.getListaDeSoftwares().size()<=this.listaDeSoftwares.size()) return 1;
		if(m.getListaDeSoftwares().size()==this.listaDeSoftwares.size()) return 1;
		if(m.getListaDeSoftwares().size()>this.listaDeSoftwares.size()) return -1;
		return 0;
	}

	

}

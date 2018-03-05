package Entidades;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CPU implements Serializable{
	
	private String codigoMaquina;
	private String nome;
	private String numeroNucleos;
	private String frequenciaMaxima;
	private String numeroProcessadoresLogicos;
	private String fabricante;
	private String arquitetura;
	private String status;
	
	
	public CPU()
	{
		
	}
	
	public CPU(String codigoMaquina,String nome, String numeroNucleos,String frequenciaMaxima,String numeroProcessadoresLogicos,String fabricante,String arquitetura,String status)
	{
		this.codigoMaquina=codigoMaquina;
		this.nome=nome;
		this.numeroNucleos=numeroNucleos;
		this.frequenciaMaxima=frequenciaMaxima;
		this.numeroProcessadoresLogicos=numeroProcessadoresLogicos;
		this.fabricante=fabricante;
		this.arquitetura=arquitetura;
		this.status=status;
		
	}
	
	public String getCodigoMaquina() {
		return codigoMaquina;
	}

	public void setCodigoMaquina(String codigoMaquina) {
		this.codigoMaquina = codigoMaquina;
	}
	
	public String getNumeroProcessadoresLogicos() {
		return numeroProcessadoresLogicos;
	}

	public void setNumeroProcessadoresLogicos(String numeroProcessadoresLogicos) {
		this.numeroProcessadoresLogicos = numeroProcessadoresLogicos;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFrequenciaMaxima()
	{
		return frequenciaMaxima;
	}
	
	public void setFrequenciaMaxima(String frequenciaMaxima)
	{
		this.frequenciaMaxima=frequenciaMaxima;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getArquitetura() {
		return arquitetura;
	}
	public void setArquitetura(String arquitetura) {
		this.arquitetura = arquitetura;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getNumeroNucleos() {
		return numeroNucleos;
	}
	public void setNumeroNucleos(String numeroNucleos) {
		this.numeroNucleos = numeroNucleos;
	}
	

}

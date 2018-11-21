package Entidades;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Som implements Serializable{
	
	private String codigoMaquina;
	private String nome;
	private String fabricante;
	private String datainstalacao;
	private String status;
	
	
	
	
	public String getCodigoMaquina() {
		return codigoMaquina;
	}
	public void setCodigoMaquina(String codigoMaquina) {
		this.codigoMaquina = codigoMaquina;
	}
	public String getStatus() {
		return status;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getDatainstalacao() {
		return datainstalacao;
	}
	public void setDatainstalacao(String datainstalacao) {
		this.datainstalacao = datainstalacao;
	}
	public String getSatus() {
		return status;
	}
	public void setStatus(String satus) {
		this.status = satus;
	}
	
	
}

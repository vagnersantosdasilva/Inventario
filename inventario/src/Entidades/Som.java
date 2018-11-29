package Entidades;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Som implements Serializable{
	private static final long serialVersionUID = 1L;
	private String codigoMaquina;
	private String nome;
	private String fabricante;
	private String datainstalacao;
	private String status;
	private String comando;
	
	public String getComando() {
		return comando;
	}
	public void setComando(String comando) {
		this.comando = comando;
	}
	
	public String getCodigoMaquina() {
		return codigoMaquina;
	}
	public void setCodigoMaquina(String codigoMaquina) {
		this.codigoMaquina = codigoMaquina;
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
	
	public boolean equals(Som som)
	{
		
		if ((this.codigoMaquina.equals(som.getCodigoMaquina()))&&
				(this.datainstalacao.equals(som.getDatainstalacao()))&&
				(this.fabricante.equals(som.getFabricante()))&&
				(this.nome.equals(som.getNome()))&&
				(this.status.equals(som.getSatus()))) return true;
		return false;
	}
	
	
}

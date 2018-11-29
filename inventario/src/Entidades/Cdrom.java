package Entidades;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Cdrom implements Serializable{
	private static final long serialVersionUID = 1L;
	private String codigoMaquina;
	private String nome;
	private String tipoDeMidea;
	private String dataInstalacao;
	private String fabricante;
	private String drive;
	private String status;
	private String comando;
	private int indice;
	
	
	
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
	public String getTipoDeMidea() {
		return tipoDeMidea;
	}
	public void setTipoDeMidea(String tipoDeMidea) {
		this.tipoDeMidea = tipoDeMidea;
	}
	public String getDataInstalacao() {
		return dataInstalacao;
	}
	public void setDataInstalacao(String dataInstalacao) {
		this.dataInstalacao = dataInstalacao;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getDrive() {
		return drive;
	}
	public void setDrive(String drive) {
		this.drive = drive;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getComando() {
		return comando;
	}
	public void setComando(String comando) {
		this.comando = comando;
	}
	
	public int getIndice() {
		return indice;
	}
	public void setIndice(int indice) {
		this.indice = indice;
	}
	public boolean equals(Cdrom cd)
	{
		if ((cd.getCodigoMaquina().equals(this.codigoMaquina)) && 
				(cd.getDataInstalacao().equals(this.dataInstalacao)) && 
				(cd.getDrive().equals(this.drive)) && 
				(cd.getFabricante().equals(this.fabricante)) && 
				(cd.getNome().equals(this.nome)) &&
				(cd.getTipoDeMidea().equals(this.tipoDeMidea))&&
				(cd.getStatus().equals(this.status))) return true;
		return false;
	}
	
}

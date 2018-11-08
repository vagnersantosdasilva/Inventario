package Entidades;

public class BD 
{
	private String nomeSGBD;
	private String nomeBanco;
	private String ipBanco;
	private String portaBanco;
	private String frequenciaBackup;
	private String modoBackup;
	private String formatoBackup;
	private String dataBackup;
	
	public BD() {}
	public BD(String nomeSGBD, String nomeBanco, String ipBanco, String portaBanco, String frequenciaBackup,
			String modoBackup, String formatoBackup, String dataBackup) {
	
		this.nomeSGBD = nomeSGBD;
		this.nomeBanco = nomeBanco;
		this.ipBanco = ipBanco;
		this.portaBanco = portaBanco;
		this.frequenciaBackup = frequenciaBackup;
		this.modoBackup = modoBackup;
		this.formatoBackup = formatoBackup;
		this.dataBackup = dataBackup;
	}
	public String getNomeSGBD() {
		return nomeSGBD;
	}
	public void setNomeSGBD(String nomeSGBD) {
		this.nomeSGBD = nomeSGBD;
	}
	public String getNomeBanco() {
		return nomeBanco;
	}
	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}
	public String getIpBanco() {
		return ipBanco;
	}
	public void setIpBanco(String ipBanco) {
		this.ipBanco = ipBanco;
	}
	public String getPortaBanco() {
		return portaBanco;
	}
	public void setPortaBanco(String portaBanco) {
		this.portaBanco = portaBanco;
	}
	public String getFrequenciaBackup() {
		return frequenciaBackup;
	}
	public void setFrequenciaBackup(String frequenciaBackup) {
		this.frequenciaBackup = frequenciaBackup;
	}
	public String getModoBackup() {
		return modoBackup;
	}
	public void setModoBackup(String modoBackup) {
		this.modoBackup = modoBackup;
	}
	public String getFormatoBackup() {
		return formatoBackup;
	}
	public void setFormatoBackup(String formatoBackup) {
		this.formatoBackup = formatoBackup;
	}
	public String getDataBackup() {
		return dataBackup;
	}
	public void setDataBackup(String dataBackup) {
		this.dataBackup = dataBackup;
	}

}

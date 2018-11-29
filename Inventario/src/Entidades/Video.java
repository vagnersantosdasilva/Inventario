package Entidades;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Video implements Serializable{
	private static final long serialVersionUID = 1L;
	private String codigoMaquina;
	private String nome;
	private String currentHorizontalResolution;
	private String currentVerticalResolution;
	private String adapterDACType;
	private String adapterRAM;
	private String currentNumberOfColors;
	private String installedDisplayDrivers;
	private String driverDate;
	private String driverVersion;
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
	public String getCurrentHorizontalResolution() {
		return currentHorizontalResolution;
	}
	public void setCurrentHorizontalResolution(String currentHorizontalResolution) {
		this.currentHorizontalResolution = currentHorizontalResolution;
	}
	public String getCurrentVerticalResolution() {
		return currentVerticalResolution;
	}
	public void setCurrentVerticalResolution(String currentVerticalResolution) {
		this.currentVerticalResolution = currentVerticalResolution;
	}
	public String getAdapterDACType() {
		return adapterDACType;
	}
	public void setAdapterDACType(String adapterDACType) {
		this.adapterDACType = adapterDACType;
	}
	public String getAdapterRAM() {
		return adapterRAM;
	}
	public void setAdapterRAM(String adapterRAM) {
		this.adapterRAM = adapterRAM;
	}
	public String getCurrentNumberOfColors() {
		return currentNumberOfColors;
	}
	public void setCurrentNumberOfColors(String currentNumberOfColors) {
		this.currentNumberOfColors = currentNumberOfColors;
	}
	public String getInstalledDisplayDrivers() {
		return installedDisplayDrivers;
	}
	public void setInstalledDisplayDrivers(String installedDisplayDrivers) {
		this.installedDisplayDrivers = installedDisplayDrivers;
	}
	public String getDriverDate() {
		return driverDate;
	}
	public void setDriverDate(String driverDate) {
		this.driverDate = driverDate;
	}
	public String getDriverVersion() {
		return driverVersion;
	}
	public void setDriverVersion(String driverVersion) {
		this.driverVersion = driverVersion;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public boolean equals(Video video)
	{
		if (this.codigoMaquina.equals(video.getCodigoMaquina()) 
				&&(this.nome.equals(video.getNome()))
				&&(this.currentHorizontalResolution.equals(video.getCurrentHorizontalResolution()))
				&&(this.currentVerticalResolution.equals(video.currentVerticalResolution))
				&&(this.adapterDACType.equals(video.adapterDACType))
				&&(this.adapterRAM.equals(video.getAdapterRAM()))
				&&(this.currentNumberOfColors.equals(video.getCurrentNumberOfColors()))
				&&(this.installedDisplayDrivers.equals(video.getInstalledDisplayDrivers()))
				&&(this.driverDate.equals(video.getDriverDate()))
				&&(this.driverVersion.equals(video.getDriverVersion()))
				&&(this.status.equals(video.getStatus()))) return true;
	
		return false;
	}
	
	
}

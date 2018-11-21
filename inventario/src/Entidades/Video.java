package Entidades;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Video implements Serializable{
	
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
	
}

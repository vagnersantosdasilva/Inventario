package Entidades;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Software implements Serializable{
	private static final long serialVersionUID = 1L;
	private String codigoMaquina;
	private int codigoSoftware;
	private String nome;
	private String arquitetura;
	private String dataInstalacao;
	private String installLocation;
	private String uninstallString;
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
	public int getCodigoSoftware() {
		return codigoSoftware;
	}
	public void setCodigoSoftware(int codigoSoftware) {
		this.codigoSoftware = codigoSoftware;
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
	public String getDataInstalacao() {
		return dataInstalacao;
	}
	public void setDataInstalacao(String dataInstalacao) {
		this.dataInstalacao = dataInstalacao;
	}
	public void setInstallLocation(String installLocation) {
		this.installLocation= installLocation;
	}
	public String getInstallLocation()
	{
		return installLocation;
	}
	public void setUninstallString(String uninstallString)
	{
		this.uninstallString = uninstallString;
	}
	
	public String getUninstallString()
	{
		return uninstallString;
	}
	
	public boolean equals(Software soft)
	{
		if ((this.codigoMaquina.equals(soft.getCodigoMaquina()))&&
				(this.nome.equals(soft.getNome()))&&
				(this.arquitetura.equals(soft.getArquitetura()))&&
				(this.dataInstalacao.equals(soft.getDataInstalacao()))&&
				(this.installLocation.equals(soft.getInstallLocation()))&&
				(this.uninstallString.equals(soft.getUninstallString())))
		{
			return true;
		}
		return false;
	}
}

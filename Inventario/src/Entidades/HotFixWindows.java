package Entidades;

import java.io.Serializable;

@SuppressWarnings("serial")
public class HotFixWindows implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String codigoMaquina;
	private String caption;
	private String csName;
	private String description;
	private String fixComments;
	private String hotFixID;
	private String installDate;
	private String installedBy;
	private String installedOn;
	private String name;
	private String servicePackInEffect;
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
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getCsName() {
		return csName;
	}
	public void setCsName(String csName) {
		this.csName = csName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFixComments() {
		return fixComments;
	}
	public void setFixComments(String fixComments) {
		this.fixComments = fixComments;
	}
	public String getHotFixID() {
		return hotFixID;
	}
	public void setHotFixID(String hotFixID) {
		this.hotFixID = hotFixID;
	}
	public String getInstallDate() {
		return installDate;
	}
	public void setInstallDate(String installDate) {
		this.installDate = installDate;
	}
	public String getInstalledBy() {
		return installedBy;
	}
	public void setInstalledBy(String installedBy) {
		this.installedBy = installedBy;
	}
	public String getInstalledOn() {
		return installedOn;
	}
	public void setInstalledOn(String installedOn) {
		this.installedOn = installedOn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getServicePackInEffect() {
		return servicePackInEffect;
	}
	public void setServicePackInEffect(String servicePackInEffect) {
		this.servicePackInEffect = servicePackInEffect;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public boolean equals(HotFixWindows hotfix) 
	{
		if ((hotfix.getCodigoMaquina().equals(this.codigoMaquina))&&
				(hotfix.getCsName().equals(this.csName))&&
				(hotfix.getDescription().equals(this.description))&&
				(hotfix.getFixComments().equals(this.fixComments))&&
				(hotfix.getHotFixID().equals(this.hotFixID))&&
				(hotfix.getInstallDate().equals(this.getInstallDate()))&&
				(hotfix.getInstalledBy().equals(this.installedBy))&&
				(hotfix.getInstalledOn().equals(this.installedOn))&&
				(hotfix.getName().equals(this.name))&&
				(hotfix.getServicePackInEffect().equals(this.servicePackInEffect))&&
				(hotfix.getStatus().equals(this.status))) return true;
		return false;
	}
	
	
}

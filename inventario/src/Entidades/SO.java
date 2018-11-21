package Entidades;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SO implements Serializable{
	private String codigoMaquina;
	private String nome;
	private String arquitetura;
	private String versao;
	private String atualizacao;
	private String hostname;
	private String ultimoBoot;
	private String dataInstalacao;
	
	public SO(String codigoMaquina,String hostname,String nome,String arquitetura,String versao,String atualizacao,String ultimoBoot,String dataInstalacao){
		
		this.codigoMaquina=codigoMaquina;
		this.hostname=hostname;
		this.nome=nome;
		this.arquitetura=arquitetura;
		this.versao=versao;
		this.atualizacao=atualizacao;
		this.ultimoBoot=ultimoBoot;
		this.dataInstalacao=dataInstalacao;
	}
	public SO(){}
	
	public String getCodigoMaquina(){
		return codigoMaquina;
	}
	
	public void setCodigoMaquina(String codigoMaquina){
		this.codigoMaquina=codigoMaquina;
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
	public String getVersao() {
		return versao;
	}
	public void setVersao(String versao) {
		this.versao = versao;
	}
	public String getAtualizacao() {
		return atualizacao;
	}
	public void setAtualizacao(String atualizacao) {
		this.atualizacao = atualizacao;
	}
	public String getHostname() {
		// TODO Auto-generated method stub
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getUltimoBoot() {
		return ultimoBoot;
	}
	public void setUltimoBoot(String ultimoBoot) {
		this.ultimoBoot = ultimoBoot;
	}
	public String getDataInstalacao() {
		return dataInstalacao;
	}
	public void setDataInstalacao(String dataInstalacao) {
		this.dataInstalacao = dataInstalacao;
	}
}

package Entidades;

import java.io.Serializable;


@SuppressWarnings("serial")
public class SO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String codigoMaquina;
	private String nome;
	private String arquitetura;
	private String versao;
	private String atualizacao;
	private String hostname;
	private String dataInstalacao;
	private String ultimoBoot;
	private String comando;
	
	public String getComando() {
		return comando;
	}
	public void setComando(String comando) {
		this.comando = comando;
	}
	
	public SO(String codigoMaquina,String nome,String arquitetura,String versao,String atualizacao,String dataInstalacao){
		
		this.codigoMaquina=codigoMaquina;
		this.nome=nome;
		this.arquitetura=arquitetura;
		this.versao=versao;
		this.atualizacao=atualizacao;
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
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getDataInstalacao() {
		return dataInstalacao;
	}
	public void setDataInstalacao(String dataInstalacao) {
		this.dataInstalacao = dataInstalacao;
	}
	public String getUltimoBoot() {
		return ultimoBoot;
	}
	public void setUltimoBoot(String ultimoBoot) {
		this.ultimoBoot = ultimoBoot;
	}
	public boolean equals(SO so)
	{
		if((this.codigoMaquina.equals(so.getCodigoMaquina())) && 
				(this.arquitetura.equals(so.getArquitetura())) &&
				(this.atualizacao.equals(so.getAtualizacao())) &&
				(this.dataInstalacao.equals(so.getDataInstalacao())) &&
				(this.hostname.equals(so.getHostname()))&&
				(this.nome.equals(so.getNome()))&&
				(this.versao.equals(so.getVersao()))&&
				(this.ultimoBoot.equals(so.getUltimoBoot()))) return true;
		return false;
	}
	
}

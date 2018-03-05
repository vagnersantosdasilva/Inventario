package Entidades;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Software implements Serializable{
	
	private String codigoMaquina;
	private String nome;
	private String arquitetura;
	private String dataInstalacao;
	
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

}

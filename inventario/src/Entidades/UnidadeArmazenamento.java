package Entidades;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UnidadeArmazenamento implements Serializable{
	
	private String codigoMaquina;
	private int codigoDrive;
	private String nome;
	private String tamanho;
	private String tipoDeInterface;
	private String tipoDeMidea;
	private String status;

	public UnidadeArmazenamento(String codigoMaquina, int codigoDrive, String nome, String tamanho, String tipoDeInterface, String tipoDeMidea,
			String status) {
		this.codigoMaquina=codigoMaquina;
		this.codigoDrive=codigoDrive;
		this.nome=nome;
		this.tamanho=tamanho;
		this.tipoDeInterface=tipoDeInterface;
		this.tipoDeMidea=tipoDeMidea;
		this.status=status;
	}
	public UnidadeArmazenamento() {
		// TODO Auto-generated constructor stub
	}
	public String getCodigoMaquina() {
		return codigoMaquina;
	}
	public void setCodigoMaquina(String codigoMaquina) {
		this.codigoMaquina = codigoMaquina;
	}
	public String getTipoDeInterface() {
		return tipoDeInterface;
	}
	public void setTipoDeInterface(String tipoDeInterface) {
		this.tipoDeInterface = tipoDeInterface;
	}
	public String getTipoDeMidea() {
		return tipoDeMidea;
	}
	public void setTipoDeMidea(String tipoDeMedea) {
		this.tipoDeMidea = tipoDeMedea;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public int getCodigoDrive() {
		return codigoDrive;
	}
	public void setCodigoDrive(int codigoDrive) {
		this.codigoDrive = codigoDrive;
	}
	
	
}

package Entidades;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UnidadeArmazenamento implements Serializable{
	private static final long serialVersionUID = 1L;
	private String codigoMaquina;
	private int codigoDrive;
	private String nome;
	private String tamanho;
	private String tipoDeInterface;
	private String tipoDeMidea;
	private String status;
	private String comando;
	
	public String getComando() {
		return comando;
	}
	public void setComando(String comando) {
		this.comando = comando;
	}

	public UnidadeArmazenamento(){}
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
	
	public boolean equals(UnidadeArmazenamento unidade)
	{
		
		if  ((this.codigoMaquina.equals(unidade.getCodigoMaquina())) && 
				(this.codigoDrive==unidade.getCodigoDrive())&& 
				(this.nome.equals(unidade.getNome()))&&
				(this.tamanho.equals(unidade.getTamanho()))&&
				(this.tipoDeInterface.equals(unidade.getTipoDeInterface()))&&
				(this.tipoDeMidea.equals(unidade.getTipoDeMidea()))&&
				(this.status.equals(unidade.getStatus()))) return true;
		return false;
	}
	
}

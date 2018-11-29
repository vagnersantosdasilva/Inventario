package Entidades;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AdaptadorDeRede  implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String codigoMaquina;
	private String nome;
	private String macAdress;
	private String indice;
	private String ultimoReset;
	private String velocidade;
	private String status;
	private String fabricante;
	private String descricao;
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
	public String getMacAdress() {
		return macAdress;
	}
	public void setMacAdress(String macAdress) {
		this.macAdress = macAdress;
	}
	public String getIndice() {
		return indice;
	}
	public void setIndice(String indice) {
		this.indice = indice;
	}
	public String getUltimoReset() {
		return ultimoReset;
	}
	public void setUltimoReset(String ultimoReset) {
		this.ultimoReset = ultimoReset;
	}
	public String getVelocidade() {
		return velocidade;
	}
	public void setVelocidade(String velocidade) {
		this.velocidade = velocidade;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public boolean equals(AdaptadorDeRede adaptador)
	{
		if ((adaptador.getCodigoMaquina().equals(this.codigoMaquina))&&
				(adaptador.getDescricao().equals(this.descricao))&& 
				(adaptador.getFabricante().equals(this.fabricante))&&
				(adaptador.getIndice().equals(this.indice))&&
				(adaptador.getMacAdress().equals(this.macAdress))&&
				(adaptador.getNome().equals(this.nome))&&
				(adaptador.getVelocidade().equals(this.velocidade))&&
				(adaptador.getStatus().equals(this.status))) return true;
		return false;
	}
	
	
}


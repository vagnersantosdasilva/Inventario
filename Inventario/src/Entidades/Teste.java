package Entidades;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Teste implements Serializable{
	
	private String nome;
	private int numero;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	

}

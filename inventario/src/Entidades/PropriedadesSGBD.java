package Entidades;

/**
 * @author ROGSIM
 *
 */
public class PropriedadesSGBD 
{
	private String sgbd;
	private String host;
	private String codificacao;
	private String nomeDoBanco;
	private String usuario;
	private String senha;
	
	public String getSGBD() {
		return sgbd;
	}
	public void setSGBD(String sgbd) {
		this.sgbd = sgbd;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getCodificacao() {
		return codificacao;
	}
	public void setCodificacao(String codificacao) {
		this.codificacao = codificacao;
	}
	public String getNomeDoBanco() {
		return nomeDoBanco;
	}
	public void setNomeDoBanco(String nomeDoBanco) {
		this.nomeDoBanco = nomeDoBanco;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}

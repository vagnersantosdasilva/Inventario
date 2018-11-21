package Entidades;

public class PropriedadesSMTP 
{
	
	private String servidor;
	private String porta;
	private String ssl;
	private String emailOrigem;
	private String login;
	private String senha;
	
	public PropriedadesSMTP() {}
	public PropriedadesSMTP(String servidor, String porta, String ssl, String emailOrigem, String login, String senha) 
	{
		this.servidor = servidor;
		this.porta = porta;
		this.ssl = ssl;
		this.emailOrigem = emailOrigem;
		this.login = login;
		this.senha = senha;
	}
	
	public String getServidor() {
		return servidor;
	}
	public void setServidor(String servidor) {
		this.servidor = servidor;
	}
	public int getPorta() {
		if (porta!=null) return	Integer.parseInt(porta.trim());
		return 0;
	}
	public void setPorta(String porta) {
		this.porta = porta;
	}
	public String getSsl() {
		return ssl;
	}
	public void setSsl(String ssl) {
		this.ssl = ssl;
	}
	public String getEmailOrigem() {
		return emailOrigem;
	}
	public void setEmailOrigem(String emailOrigem) {
		this.emailOrigem = emailOrigem;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

}

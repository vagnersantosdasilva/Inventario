package Entidades;

public class ParametrosEmail 
{
	private String nomeRemetente;
	private String smtp;
	private int porta;
	private String emailOrigem;
	private String login;
	private String acesso;
	
	
	public String getNomeRemetente() {
		return nomeRemetente;
	}
	public void setNomeRemetente(String nomeRemetente) {
		this.nomeRemetente = nomeRemetente;
	}
	public String getSmtp() {
		return smtp;
	}
	public void setSmtp(String smtp) {
		this.smtp = smtp;
	}
	public int getPorta() {
		return porta;
	}
	public void setPorta(int porta) {
		this.porta = porta;
	}
	public void setPorta(String porta) 
	{
		if (porta!=null) {
			this.porta=Integer.parseInt(porta.trim());
		}
		else
		{
			this.porta=465;
		}
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
		return acesso;
	}
	public void setSenha(String senha) {
		this.acesso = senha;
	}
	
	

}

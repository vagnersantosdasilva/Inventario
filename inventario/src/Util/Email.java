package Util;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import Entidades.ParametrosEmail;

public class Email 
{
	private String nome;
	private String smtpServidor;
	private int smtpPorta;
	private String emailDestino;
	private String emailOrigem;
	private String tituloMensagem;
	private String mensagem;
	private String login;
	private String acesso;
	Cripto cripto = new Cripto(31,13,17,7,2,3,1);
	public Email(ParametrosEmail parametros,String destino,String titulo,String mensagem)
	{
		this.nome=parametros.getNomeRemetente();
		this.smtpServidor = parametros.getSmtp();
		this.smtpPorta = parametros.getPorta();
		this.emailDestino = destino;
		this.emailOrigem = parametros.getEmailOrigem();
		this.tituloMensagem = titulo;
		this.mensagem = mensagem;
		this.login = parametros.getLogin();
		this.acesso = cripto.decifrar(parametros.getSenha());
		
	}
	public Email(String smtpServidor, int smtpPorta, String emailDestino, String emailOrigem,String nome, String tituloMensagem,
			String mensagem, String login, String acesso) 
	{
		this.nome=nome;
		this.smtpServidor = smtpServidor;
		this.smtpPorta = smtpPorta;
		this.emailDestino = emailDestino;
		this.emailOrigem = emailOrigem;
		this.tituloMensagem = tituloMensagem;
		this.mensagem = mensagem;
		this.login = login;
		this.acesso = cripto.decifrar(acesso);
	}
	public void enviarEmail() throws EmailException 
	{
		   SimpleEmail email = new SimpleEmail();
		   email.setHostName(smtpServidor);
		   email.setSmtpPort(smtpPorta);
		   email.addTo(emailDestino, nome);
		   email.setFrom(emailOrigem, nome);
		   email.setSubject(tituloMensagem);
		   email.setMsg(mensagem);
		   email.setSSL(true);
		   email.setAuthenticator(new DefaultAuthenticator(login, acesso));
		   email.send();
	}
}

package Entidades;

public class Propriedades 
{
	private String usuario;
	private String senha;
	private String servidor;
	private String porta;
	private String api;
	private String nomeDoBanco;
	private String sgbd;
	private String driver;
	
	
	public Propriedades(PropriedadesSGBD bd,PropriedadesJDBC driver) 
	{
		this.usuario=bd.getUsuario();
		this.senha=bd.getSenha();
		this.servidor=bd.getHost();
		this.sgbd=bd.getSGBD();
		this.nomeDoBanco=bd.getNomeDoBanco();
		this.porta=driver.getPorta();
		this.api=driver.getApi();
		this.driver=driver.getDriver();
		
	}

	public Propriedades() {
		
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

	public String getServidor() {
		return servidor;
	}

	public void setServidor(String servidor) {
		this.servidor = servidor;
	}

	public String getPorta() {
		return porta;
	}

	public void setPorta(String porta) {
		this.porta = porta;
	}

	public String getApi() {
		return api;
	}

	public void setApi(String api) {
		this.api = api;
	}

	public String getNomeDoBanco() {
		return nomeDoBanco;
	}

	public void setNomeDoBanco(String nomeDoBanco) {
		this.nomeDoBanco = nomeDoBanco;
	}

	public String getSgbd() {
		return sgbd;
	}

	public void setSgbd(String sgbd) {
		this.sgbd = sgbd;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}
	
}

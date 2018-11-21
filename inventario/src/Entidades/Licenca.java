package Entidades;

public class Licenca {
	
	private String codigoMaquina;
	private String nomeSoftware;
	private String chave;
	private String dataExpiracao;//YYYY-MM-DD
	
	
	public String getCodigoMaquina() {
		return codigoMaquina;
	}
	public void setCodigoMaquina(String codigoMaquina) {
		this.codigoMaquina = codigoMaquina;
	}
	public String getNomeSoftware() {
		return nomeSoftware;
	}
	public void setNomeSoftware(String software) {
		this.nomeSoftware = software;
	}
	public String getChave() {
		return chave;
	}
	public void setChave(String chave) {
		this.chave = chave;
	}
	public String getDataExpiracao() {
		return dataExpiracao;
	}
	public void setDataExpiracao(String dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}
	
	private String converteData(String data)
	{
		return null;
	}
	private int calculaExpiracao()
	{
		return 0;
	}
	
}

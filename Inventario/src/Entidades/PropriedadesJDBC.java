package Entidades;

public class PropriedadesJDBC 
{
	/*
	 * 		lista1.add("driverMySql=com.mysql.jdbc.Driver");
	 		lista1.add("apiMySql=jdbc:mysql");
			lista1.add("portaMySql=3306");
			
	*/
	private String driver;
	private String api;
	private String porta;
	
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getApi() {
		return api;
	}
	public void setApi(String api) {
		this.api = api;
	}
	public String getPorta() {
		return porta;
	}
	public void setPorta(String porta) {
		this.porta = porta;
	}
	
}

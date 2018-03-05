package Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Hardware implements Serializable{
	
	private CPU cpu;
	private List <Memoria>listaMemorias =new ArrayList<Memoria>();
	private List <UnidadeArmazenamento>listaUnidadesArmazenamento = new ArrayList<UnidadeArmazenamento>();
	
	private PlacaMae placamae;
	private Som som;
	private Video video;
	
	
	
	public CPU getCpu() {
		return cpu;
	}
	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}
	public List<Memoria> getListaMemorias() {
		return listaMemorias;
	}
	public void adicionarMemoria(Memoria memoria) {
		listaMemorias.add(memoria);
	}
	public PlacaMae getPlacamae() {
		return placamae;
	}
	public void setPlacamae(PlacaMae placamae) {
		this.placamae = placamae;
	}
	public Som getSom() {
		return som;
	}
	public void setSom(Som som) {
		this.som = som;
	}
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	
	public void adicionarUnidadeArmazenamento(UnidadeArmazenamento unidadeArmazenamento) {
		listaUnidadesArmazenamento.add(unidadeArmazenamento);
	}
	
	public void setListaUnidadeArmazenamento(List listaUnidadesArmazenamento)
	{
		this.listaUnidadesArmazenamento=listaUnidadesArmazenamento;
	}
	public void setListaDeMemorias(List listaMemorias)
	{
		this.listaMemorias=listaMemorias;
	}
	
	public List<UnidadeArmazenamento> getListaUnidadesArmazenamento()
	{
		return listaUnidadesArmazenamento;
	}
	
	
	
	

}

package Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Hardware implements Serializable{
	private static final long serialVersionUID = 1L;
	private CPU cpu;
	private List listaDeMemorias =new ArrayList();
	private List listaDeUnidadesDeArmazenamento = new ArrayList();
	private List listaDeUnidadesDeCDDVD = new ArrayList();
	private PlacaMae placamae;
	private Som som;
	private Video video;
	
	public CPU getCpu() {
		return cpu;
	}
	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}
	public List getListaDeMemorias() {
		return listaDeMemorias;
	}
	public void setListaDeMemorias(List listaDeMemorias) {
		this.listaDeMemorias = listaDeMemorias;
	}
	public List getListaDeUnidadesDeArmazenamento() {
		return listaDeUnidadesDeArmazenamento;
	}
	public void setListaDeUnidadesDeArmazenamento(List listaDeUnidadesDeArmazenamento) {
		this.listaDeUnidadesDeArmazenamento = listaDeUnidadesDeArmazenamento;
	}
	public List getListaDeUnidadesDeCDDVD() {
		return listaDeUnidadesDeCDDVD;
	}
	public void setListaDeUnidadesDeCDDVD(List listaDeUnidadesDeCDDVD) {
		this.listaDeUnidadesDeCDDVD = listaDeUnidadesDeCDDVD;
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
	
	
	
	
	
	
}

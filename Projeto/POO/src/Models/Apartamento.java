package Models;

import java.util.ArrayList;

public class Apartamento {

	private String andar;
	private String bloco;
	private String predio;
	private String numero;
	private ArrayList<Morador> residentes;
	
	public Apartamento() {
		residentes = new ArrayList<Morador>();
	}

	public String getAndar() {
		return andar;
	}

	public void setAndar(String andar) {
		this.andar = andar;
	}

	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	public String getPredio() {
		return predio;
	}

	public void setPredio(String predio) {
		this.predio = predio;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public ArrayList<Morador> getResidentes() {
		return residentes;
	}

	public void setResidentes(ArrayList<Morador> residentes) {
		this.residentes = residentes;
	}
	
	public void addResidentes(Morador item) {
		this.residentes.add(item);
	}
	
	public void removeResidentes(Morador item) {
		this.residentes.remove(item);
	}
}

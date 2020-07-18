package Models;

import java.util.ArrayList;

public class Apartamento {
	private int id;
	private String andar;
	private String bloco;
	private String predio;
	private String numero;
	private ArrayList<Pessoa> residentes;
	
	public Apartamento(int id, String andar, String bloco, String predio, String numero, ArrayList<Pessoa>  pessoas) {
		this.id = id;
		this.andar = andar;
		this.bloco = bloco;
		this.predio = predio;
		this.numero = numero;
		this.residentes = pessoas;
	}
	
	public Apartamento(String andar, String bloco, String predio, String numero) {
		this.andar = andar;
		this.bloco = bloco;
		this.predio = predio;
		this.numero = numero;
	}
	
	public Apartamento(int id, String andar, String bloco, String predio, String numero) {
		this.id =  id;
		this.andar = andar;
		this.bloco = bloco;
		this.predio = predio;
		this.numero = numero;
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

	public ArrayList<Pessoa> getResidentes() {
		return residentes;
	}

	public void setResidentes(ArrayList<Pessoa> residentes) {
		this.residentes = residentes;
	}
	
	public void addResidentes(Pessoa item) {
		this.residentes.add(item);
	}
	
	public void removeResidentes(Pessoa item) {
		this.residentes.remove(item);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

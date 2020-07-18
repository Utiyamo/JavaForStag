package Models;

public class Pessoa {

	private String nome;
	private String rg;
	
	public Pessoa(String name, String doc) {
		this.nome = name;
		this.rg = doc;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}
	
	
}

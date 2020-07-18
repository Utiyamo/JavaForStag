package Models;

public class Pessoa {

	private int id;
	private String nome;
	private String rg;
	private int tipo; 
	
	public Pessoa(String name, String doc, int tipo) {
		this.nome = name;
		this.rg = doc;
		this.tipo = tipo;
	}
	
	public Pessoa(int id, String name, String doc, int tipo) {
		this.id =  id;
		this.nome = name;
		this.rg = doc;
		this.tipo =  tipo;
	}
	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
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
	
	public int getId() {
		return id;
	}
	
	public int setId(int id) {
		return this.id;
	}
	
}

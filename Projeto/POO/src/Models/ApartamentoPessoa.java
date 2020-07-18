package Models;

public class ApartamentoPessoa {
	private int id;
	private int pessoa_id;
	private int apartamento_id;
	
	public ApartamentoPessoa(int pessoa_id, int apartamento_id) {
		super();
		this.pessoa_id = pessoa_id;
		this.apartamento_id = apartamento_id;
	}
	public ApartamentoPessoa(int id, int pessoa_id, int apartamento_id) {
		super();
		this.id = id;
		this.pessoa_id = pessoa_id;
		this.apartamento_id = apartamento_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPessoa_id() {
		return pessoa_id;
	}
	public void setPessoa_id(int pessoa_id) {
		this.pessoa_id = pessoa_id;
	}
	public int getApartamento_id() {
		return apartamento_id;
	}
	public void setApartamento_id(int apartamento_id) {
		this.apartamento_id = apartamento_id;
	}	
}

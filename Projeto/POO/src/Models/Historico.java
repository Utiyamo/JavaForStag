package Models;


public class Historico {
	private int id;
	private Pessoa pessoa;
	private String dataEvento;
	private String descricaoEvento;
	private Apartamento destino;
	private int tipoAcao;
	private boolean entrou;
	private String entrega;
	
	public Historico(int id, Pessoa pessoa, String dataEvento, String descricaoEvento, Apartamento destino, int tipoAcao, boolean entrou, String entrega) {
		this.id = id;
		this.pessoa = pessoa;
		this.dataEvento = dataEvento;
		this.descricaoEvento = descricaoEvento;
		this.destino = destino;
		this.tipoAcao = tipoAcao;
		this.entrou = entrou;
		this.entrega = entrega;
	}
	
	public Historico(Pessoa pessoa, String dataEvento, String descricaoEvento, Apartamento destino, int tipoAcao, boolean entrou, String entrega) {
		this.pessoa = pessoa;
		this.dataEvento = dataEvento;
		this.descricaoEvento = descricaoEvento;
		this.destino = destino;
		this.tipoAcao = tipoAcao;
		this.entrou = entrou;
		this.entrega = entrega;
		
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(String dataEvento) {
		this.dataEvento = dataEvento;
	}

	public String getDescricaoEvento() {
		return descricaoEvento;
	}

	public void setDescricaoEvento(String descricaoEvento) {
		this.descricaoEvento = descricaoEvento;
	}

	public Apartamento getDestino() {
		return destino;
	}

	public void setDestino(Apartamento destino) {
		this.destino = destino;
	}

	public int getTipoAcao() {
		return tipoAcao;
	}

	public void setTipoAcao(int tipoAcao) {
		this.tipoAcao = tipoAcao;
	}

	public boolean isEntrou() {
		return entrou;
	}

	public void setEntrou(boolean entrou) {
		this.entrou = entrou;
	}

	public String getEntrega() {
		return entrega;
	}

	public void setEntrega(String entrega) {
		this.entrega = entrega;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}

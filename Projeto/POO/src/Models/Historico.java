package Models;

import java.util.Date;

public class Historico {

	private Pessoa pessoa;
	private Date dataEvento;
	private String descricaoEvento;
	private Apartamento destino;
	private int tipoAcao;
	private boolean entrou;
	
	public Historico() {
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Date getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(Date dataEvento) {
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
	
}

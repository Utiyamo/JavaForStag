package Controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Models.Apartamento;
import Models.Historico;
import Models.Pessoa;

public class HistoricoES_Controller {

	private Historico historico;
	private SimpleDateFormat formaterDate;
	
	public HistoricoES_Controller() {
		historico = new Historico();
		formaterDate = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
	}
	
	public void addHistorico(String nome, String doc, String andar, String bloco, String predio, String numero, String descricao, int tipo, boolean InOut) {
		Pessoa individuo = new Pessoa(nome, doc);
		
		Date date = new Date(System.currentTimeMillis());
		
		Apartamento ap = new Apartamento();
		ap.setAndar(andar);
		ap.setBloco(bloco);
		ap.setPredio(predio);
		ap.setNumero(numero);
		
		historico.setPessoa(individuo);
		historico.setDescricaoEvento(descricao);
		historico.setDestino(ap);
		historico.setTipoAcao(tipo);
		historico.setEntrou(InOut);
		historico.setDataEvento(date);
		
	}
	
	public ArrayList<Apartamento> getApartamentos(){
	
		ArrayList<Apartamento> retorno = new ArrayList<Apartamento>();
		
		
		return retorno;

	}
	
	public Pessoa getIndividuoPorRG(String rg) {
		
		Pessoa retorno = new Pessoa("", rg);
		
		return retorno;
	}
	
}

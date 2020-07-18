package Controllers;

import javax.swing.JOptionPane;

import DAL.HistoricoDAO;
import Models.Apartamento;
import Models.Historico;
import Models.Pessoa;

public class HistoricoController {
	public boolean IncluirHistorico (Pessoa pessoa, String dataEvento, String descricaoEvento, Apartamento destino, int tipoAcao, boolean entrou, String entrega) {
		try {
			HistoricoDAO dao = new HistoricoDAO();
			Historico  historico = new Historico(pessoa, dataEvento, descricaoEvento, destino, tipoAcao, entrou, entrega);
			dao.IncluirHistorico(historico);
			return true;
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro para incluir Pessoa");
		}
		return false;
	}
	
}

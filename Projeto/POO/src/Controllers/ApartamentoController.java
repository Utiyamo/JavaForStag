package Controllers;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAL.ApartamentoDAO;
import Models.Apartamento;
import Models.Pessoa;

public class ApartamentoController {
	public boolean incluirApartamento (String andar, String bloco, String predio, String numero, ArrayList<Pessoa> moradores) {
		try {
			ApartamentoDAO dao = new ApartamentoDAO();
			Apartamento apartamento = new Apartamento(andar, bloco, predio, numero, moradores);
			dao.IncluirApartamento(apartamento);
			return true;
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro para incluir Pessoa");
		}
		return false;
	}
	
}

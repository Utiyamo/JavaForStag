package Controllers;

import javax.swing.JOptionPane;

import DAL.ApartamentoDAO;
import DAL.PessoaDAO;
import Models.Apartamento;
import Models.Pessoa;

public class ApartamentoController {
	public boolean incluirApartamento (String andar, String bloco, String predio, String numero) {
		try {
			ApartamentoDAO dao = new ApartamentoDAO();
			Apartamento apartamento = new Apartamento(andar, bloco, predio, numero);
			dao.IncluirApartamento(apartamento);
			return true;
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro para incluir Pessoa");
		}
		return false;
	}
	
	public Apartamento consultarApartamento(int id) {
		try {
			ApartamentoDAO daoApartamento = new ApartamentoDAO();
			Apartamento apartamento = daoApartamento.BuscarApartamento(id);
			
			if (apartamento == null) {
				return null;
			} else {
				return apartamento;
			}
			
		}catch(Exception e){
			throw e;
		}
	}
}

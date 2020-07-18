package Controllers;

import javax.swing.JOptionPane;

import DAL.PessoaDAO;
import Models.Pessoa;

public class PessoaController {
	public boolean incluirPessoa ( String nome, String rg, int tipo) {
		try {
			PessoaDAO dao = new PessoaDAO();
			Pessoa pessoa = new Pessoa(nome, rg, tipo);
			dao.IncluirPessoa(pessoa);
			return true;
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro para incluir Pessoa");
		}
		return false;
	}
	
}

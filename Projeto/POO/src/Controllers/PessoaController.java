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
	
	public Pessoa consultarPessoa(int id) {
		try {
			PessoaDAO daoPessoa = new PessoaDAO();
			Pessoa pessoa = daoPessoa.BuscarPessoa(id);
			
			if (pessoa == null) {
				return null;
			} else {
				return pessoa;
			}
			
		}catch(Exception e){
			throw e;
		}
	}
	
}

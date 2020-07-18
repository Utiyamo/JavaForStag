package DAL;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import BD.ConexaoDB;
import Models.Pessoa;

public class PessoaDAO extends ConexaoDB  {
	public void IncluirPessoa(Pessoa pessoa)  {
		try {
			openConnection();
			String sql = "INSERT INTO Pessoa (nome,rg,tipo) VALUES (?,?,?)";
			int insertID;
			PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, pessoa.getNome());
			st.setString(2, pessoa.getRg());
			st.setInt(3, pessoa.getTipo());
			insertID = st.executeUpdate();
			pessoa.setId(insertID);
			con.commit();
		}catch (Exception e) {
			e.printStackTrace();
			if (con != null) {
	            try {
	                System.err.print("Rollback, erro durante operação");
	                con.rollback();
	            } catch(SQLException ex) {
	               ex.printStackTrace();
	            }
	        }
		}finally {
			closeConnection();
		}	
	}
}


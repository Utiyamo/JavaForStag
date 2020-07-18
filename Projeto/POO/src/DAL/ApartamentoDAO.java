package DAL;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import BD.ConexaoDB;
import Models.Apartamento;

public class ApartamentoDAO extends ConexaoDB  {
	public void IncluirApartamento(Apartamento apartamento)  {
		try {
			openConnection();
			String sql = "INSERT INTO Apartamento (andar, bloco, predio, numero) VALUES (?,?,?,?)";
			int insertID;
			PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, apartamento.getAndar());
			st.setString(2, apartamento.getBloco());
			st.setString(3, apartamento.getPredio());
			st.setString(4, apartamento.getNumero());
			insertID = st.executeUpdate();
			apartamento.setId(insertID);
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


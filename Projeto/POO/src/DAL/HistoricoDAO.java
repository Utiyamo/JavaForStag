package DAL;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import BD.ConexaoDB;
import Models.Historico;
import Models.Pessoa;

public class HistoricoDAO extends ConexaoDB  {
	public void IncluirHistorico(Historico historico)  {
		try {
			openConnection();
			String sql = "INSERT INTO Pessoa (pessoa_id, DataEvento, descricaoEvento, apartamento_id, tipoAcao, entrou, entrega) VALUES (?,convert(datetime,?,103),?,?,?,?,?)";
			int insertID;
			PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, historico.getPessoa().getId());
			st.setString(2, historico.getDataEvento());
			st.setString(3, historico.getDescricaoEvento());
			st.setInt(4, historico.getDestino().getId());
			st.setInt(5, historico.getTipoAcao());
			st.setBoolean(6, historico.isEntrou());
			st.setString(7, historico.getEntrega());
			insertID = st.executeUpdate();
			historico.setId(insertID);
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


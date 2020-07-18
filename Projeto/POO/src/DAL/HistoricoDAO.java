package DAL;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import BD.ConexaoDB;
import Controllers.ApartamentoController;
import Controllers.PessoaController;
import Models.Apartamento;
import Models.Historico;
import Models.Pessoa;

public class HistoricoDAO extends ConexaoDB  {
	public void IncluirHistorico(Historico historico)  {
		try {
			openConnection();
			String sql = "INSERT INTO Historico (pessoa_id, DataEvento, descricaoEvento, apartamento_id, tipoAcao, entrou, entrega) VALUES (?,convert(datetime,?,103),?,?,?,?,?)";
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
	
	public Historico BuscarHistorico(int id) {
		Historico historico;
		try {
			openConnection();
			String sql = "SELECT * FROM Historico h WHERE h.id = ?";			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet resultSet = st.executeQuery();
			
			PessoaController pessoaController = new PessoaController();
			Pessoa pessoa = pessoaController.consultarPessoa(resultSet.getInt("pessoa_id"));
			
			ApartamentoController apartamentoController = new ApartamentoController();
			Apartamento apartamento = apartamentoController.consultarApartamento(resultSet.getInt("apartamento_id"));
			
			if(resultSet.next()) {
				historico = new Historico(
							resultSet.getInt("id"),
							pessoa,
							resultSet.getString("DataEvento"),
							resultSet.getString("descricaoEvento"),
							apartamento,
							resultSet.getInt("tipoAcao"),
							resultSet.getBoolean("entrou"),
							resultSet.getString("entrega")
						);
				return historico;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		return null;
	}
	
	public void ExcluirHistorico(int id) {
		try {
			openConnection();
			
			String sql = "DELETE Historico WHERE id = ?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			
			st.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			if (con != null) {
	            try {
	                con.rollback();
	            } catch(SQLException ex) {
	               ex.printStackTrace();
	            }
	        }

			e.printStackTrace();
		}finally {
			closeConnection();
		}
	}
}

